import React from 'react';



export class List extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            items: this.props.items,
            loading: false,
        };
    }

    handleClickItem(itemIndex) {
        const newItems = this.state.items.filter((item, i) => {
            return i !== itemIndex;
        })
        this.setState({ items: newItems });
    }

    handleClear() {
        this.setState({ items: [] });
    }

    render() {
        const renderedItems = this.state.items.map((item, i) => {
            return (
                <div key={i} onClick={() => this.handleClickItem(i)}>
                    {i} - {item}
                </div >
            );
        });

        return (
            <div>
                {renderedItems.length > 0 ? renderedItems : null}
                <button onClick={() => this.handleClear()}>Очистить</button>
            </div>
        )
    }
}