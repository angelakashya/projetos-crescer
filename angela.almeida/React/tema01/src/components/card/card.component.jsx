import './style.css'
import React from 'react'

export function Card({ children }) {

    let BackgroungStyle = {
        width: "300px",
        height: "130px",
        backgroundSize: "300px",
        backgroundImage: `url(${children.background})`,
    };

    return (
        <h1>Seleção de Heróis</h1>,
        <div className="card">
            <div className="container" className={children.color}>
                <div className='image-background' style={BackgroungStyle} >
                    <div className="avatar">
                        <img src={children.image} alt='' />
                    </div>
                    <div className="text">
                        <span>{children.name}</span>
                        <p>{children.description}</p>
                    </div>
                </div>
            </div>
        </div>
    )
}

export default Card;