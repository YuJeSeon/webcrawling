import React, { useEffect } from 'react';


function Board(props) {
    const typeNames = {
        'now': '현재 Best of Article',
        'daily': '일간 Best of Article',
        'weekly': '주간 Best of Article',
        'monthly': '월간 Best of Article',
    }
    const communityNames = ['클리앙', '보배드림', '오늘의 유머']
    const { type } = props;
    const [articles, setArticles] = React.useState([]);

    function getArticles(type) {
        if (type == null)
            return;
        fetch(`https://api-boa.devcherio.com/api/crawling?type=${type}`)
            .then(res => res.json())
            .then(data => {
                console.log(data);
                setArticles(data.data);
            })
            .catch(err => console.log(err));
    }

    useEffect(() => {
        getArticles(type);
    }, [type]);

    return (
        <>
            <div className="mt-3">
                <h3 className="mb-3">{typeNames[type]}</h3>
                <table className='table table-bordered table-hover'>
                    <thead>
                        <tr>
                            <th className='text-center'>커뮤니티</th>
                            <th className='text-center'>제목</th>
                            <th className='text-center'>크롤링 시간</th>
                        </tr>
                    </thead>
                    <tbody>
                        {articles.map((article, index) => {
                            return (
                                <tr key={index}>
                                    <td className='text-center'>{communityNames[article.type]}</td>
                                    <td className='text-center'>
                                        <a href={article.url} target="_blank" className='text-decoration-none link-dark'>{article.title}</a>
                                    </td>
                                    <td className='text-center'>{article.created_at}</td>
                                </tr>
                            )
                        })}
                    </tbody>
                </table>
            </div>
        </>
    )
}
Board.defaultProps = {
    type: 'now',
}
export default Board;