import React from "react";
import { Indicator } from "./Indicator";

const items = [
    {
        name: 'Total Users',
        value: '2500',
    },
    {
        name: 'Average Time',
        value: '123.50'
    },
    {
        name: 'Total Males',
        value: '2,500'
    },
    {
        name: 'Total Females',
        value: '4,567'

    },
    {
        name: 'Total Collections',
        value: '2,315'
    },
    {
        name: 'Total Connections',
        value: '7,325'
    },
]

export class IndicatorsList extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            items: items,
        }
    }

    render() {

        const { items } = this.state;

        const result = items.map((item, i) => {
            return (
                <Indicator key={'indicator' + i} obj={item} />
            )
        })

        return (
            <div className='element wrapper' >
                {result}
            </div>
        )
    }
}