import React from 'react';

export default function Header() {

    return (
        <header className="py-3 mb-4 border-bottom">
            <div className="container d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
                <a href="/" className="d-flex align-items-center mb-2 mb-lg-0 link-body-emphasis text-decoration-none">
                    <svg className="bi me-2" width="40" height="32"><use href="#bootstrap"></use></svg>
                    <span className="fs-4">BoA</span>
                </a>
                <ul className="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
                    <li><a href="?type=now" className="nav-link px-2 link-body-emphasis">현재 Best</a></li>
                    <li><a href="?type=daily" className="nav-link px-2 link-body-emphasis">일간 Best</a></li>
                    <li><a href="?type=weekly" className="nav-link px-2 link-body-emphasis">주간 Best</a></li>
                    <li><a href="?type=monthly" className="nav-link px-2 link-body-emphasis">월간 Best</a></li>
                </ul>
            </div>
        </header>
    );
}