import React from 'react'
import './style.css'

export function Card({title, children}) { 

    return (
        <div className="menu-container">
            <div className="menu-border">
                <div className="menu-card">
                    <div className="menu-title">{title}</div>
                    {children}
                </div>
            </div>
        </div>
    )

}