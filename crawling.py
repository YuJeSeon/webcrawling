import requests
from bs4 import BeautifulSoup
import pymysql
from datetime import datetime
import re

# Mysql 연결 정보
DB_HOST = 'localhost'
DB_USER = 
DB_PASSWORD = 
DB_NAME = 'webcrawling'

TARGETS = [
    ['https://www.clien.net/service/recommend', 'a.list_subject'],
    ['https://www.bobaedream.co.kr/list?code=best', 'a.bsubject'],
    ['https://www.todayhumor.co.kr/board/list.php?table=humorbest', 'td.subject > a']
]

# DB
class DB:

    def __init__(self):
        self.db = pymysql.connect(host=DB_HOST, user=DB_USER, password=DB_PASSWORD, database=DB_NAME, charset='utf8mb4')
        self.cursor = self.db.cursor()

    def insert(self, sql, data):
        try:
            self.cursor.execute(sql, data)
            self.db.commit()
        except pymysql.IntegrityError as e:
            # 중복된 경우 id 값을 가장 큰 값 + 1로 설정
            sql_max_id = 'SELECT MAX(id) FROM crawling WHERE url IS NOT NULL'
            self.cursor.execute(sql_max_id)
            max_id = self.cursor.fetchone()[0] + 1
            sql_alter_auto_increment = f'ALTER TABLE crawling AUTO_INCREMENT = {max_id}'
            self.cursor.execute(sql_alter_auto_increment)

class Cralwer:

    # 크롤링 함수
    def get_html(self, url, tag):
        response = requests.get(url)
        if response.status_code == 200:
            html = response.content.decode('utf-8','replace')
            soup = BeautifulSoup(html, 'html.parser')
            results = soup.select(tag)
            return results

    def clean_title(self, title):
        # 정규표현식을 사용하여 '\n(임의의단어)\n' 패턴을 빈 문자열로 대체하여 제거
        cleaned_title = re.sub(r'^\n.*\n', '', title)
        return cleaned_title.strip()        

    def get_main_url(self, url):
        index = url.find('/', len('https://'))
        if index != -1:
            return url[:index]
        else:
            return url
    
if __name__ == '__main__':
    crawler = Cralwer()
    db = DB()

    for index, target in enumerate(TARGETS):
        articles = crawler.get_html(target[0], target[1])
        article_list = []

        # 크롤링 결과를 역순으로 리스트에 저장
        for article in reversed(articles):
            title = crawler.clean_title(article.text)
            detail_url = article.get('href')
            url = crawler.get_main_url(target[0]) + detail_url
            article_list.append((index, title, url))

        for article in article_list:
            sql = 'INSERT INTO crawling (type, title, url) VALUES(%s, %s, %s)'
            db.insert(sql, article)