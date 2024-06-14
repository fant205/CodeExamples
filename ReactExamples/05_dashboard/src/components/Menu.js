import React from "react";
import './Style.css';

export class Menu extends React.Component {

    render() {
        return (
            <div className='element'>
                <button>Меню</button>
                <button>Войти</button>
            </div>
        )
    }
}