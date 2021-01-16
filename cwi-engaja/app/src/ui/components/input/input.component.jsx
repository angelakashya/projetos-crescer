import React from 'react'
import './input.style.css'

export function Input({ name, label, handleChange, value, type, required }) {
    function onChange(event) {
        handleChange(event.target.value)
    }

    return (
        <div className="input--container">
            <label className="label" htmlFor={name}>{label}</label>
            <input
                type={type}
                onChange={onChange}
                name={name}
                value={value}
                required={required}
                className="input"
            />
        </div>
    )
}
