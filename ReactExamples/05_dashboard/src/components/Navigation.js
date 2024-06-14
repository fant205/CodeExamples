import React from "react";
import './Navigation.css';

const items = [
    'Home',
    'Forms',
    'UI Elements'
]

export class Navigation extends React.Component {

    constructor(props) {
        super(props);
        console.log('constructor');
        this.state = {
            items: items,
        }
    }

    render() {

        const { items } = this.state;
        const result = items.map((item, i) => {
            return (
                <div key={i}> {i} - {item} </div>
            )
        });

        return (
            <div className="navigation">
                {result}
            </div>
        )
    }
}