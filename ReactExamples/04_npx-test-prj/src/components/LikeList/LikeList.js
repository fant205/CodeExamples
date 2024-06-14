import React from "react";
import { List } from "../List/List";
import { LikeButton } from "../LikeButton/LikeButton";

const listItems = [
    {
        name: "VK",
        rating: 0,
    },
    {
        name: "DZEN",
        rating: 0,
    },
    {
        name: "Telegramm",
        rating: 0,
    }
];

export class LikeList extends React.Component {
    constructor(props) {
        super(props);
        console.log("LikeList constructor");
        this.state = {
            items: listItems,
            selectedItem: null,
        };
        this.handleClickItem = this.handleClickItem.bind(this);
    }

    handleClickButton() {
        console.log("handleClickButton");

        const { items, selectedItem } = this.state;

        if (!selectedItem) {
            console.log("selectedItem: " + selectedItem);
            return;
        }

        const newListItem = items.map((item) => {
            return selectedItem.name === item.name ? {
                ...item,
                rating: item.rating + 1,
            } : item;
        });

        this.setState({ items: newListItem });
    }

    handleClickItem(itemIndex) {
        console.log("handleClickItem");

        if (itemIndex < 0) {
            return;
        }

        this.setState({
            selectedItem: this.state.items[itemIndex]
        })

    }

    render() {
        return (
            <div>
                <LikeButton onClick={() => this.handleClickButton()} />
                <List propItems={this.state.items} onClickItem={this.handleClickItem} selectedItem={this.state.selectedItem} />
            </div>
        )
    }
}