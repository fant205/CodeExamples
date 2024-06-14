import React from 'react';
import PropTypes from 'prop-types';
import './List.css';

export class List extends React.Component {

    render() {
        const { propItems, selectedItem } = this.props;

        const renderedItems = propItems.map((item, i) => {
            const isSelected = selectedItem && selectedItem.name === item.name;
            return (
                <div className={isSelected ? 'is-selected' : ''} key={i} onClick={() => this.props.onClickItem(i)}>
                    {i} - {item.name} - {item.rating}
                </div >
            );
        });

        return (
            <div>
                {renderedItems.length > 0 ? renderedItems : null}
            </div>
        )
    }
}

List.propTypes = {
    propItems: PropTypes.arrayOf(
        PropTypes.shap({
            name: PropTypes.string,
            rating: PropTypes.number
        })
    )
}

List.defaultProps = {
    propItems: [],
    selectedItem: null
}