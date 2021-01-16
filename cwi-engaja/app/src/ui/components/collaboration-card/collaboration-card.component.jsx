import React from 'react'
import './collaboration-card.style.css'

export function CollaborationCard({ primeiraPalavra, segundaPalavra, description, children }) {

  return (
    <div className="card">
      <div className="titulo-card">
        <h2>{primeiraPalavra}<strong>{segundaPalavra}</strong></h2>
        <span className="pipe-card"></span>
      </div>
      <p>{description}</p>
      <div>
        {children}
      </div>
    </div>
  );
}
