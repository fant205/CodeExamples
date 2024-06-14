import React from "react";
import './Report.css';

export class Report extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            elementStyle: 'element reportMax'
        }
    }

    handleClick() {
        console.log("handleClick");

        const elementStyle = this.state.elementStyle;
        var result = 'reportMax';
        if (elementStyle.indexOf('reportMax') > -1) {
            result = elementStyle.replace('reportMax', 'reportMin');
        } else {
            result = elementStyle.replace('reportMin', 'reportMax');
        }

        this.setState({
            elementStyle: result
        })
    }

    render() {
        return (
            <div className={this.state.elementStyle} >
                Отчет
                <button onClick={() => this.handleClick()}>скрыть</button>
                <button>закрыть</button>
            </div>
        )
    }
}