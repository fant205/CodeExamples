'use strict';

class LikeButton extends React.Component {
    constructor(props) {
        super(props);
        this.state = { liked: false };
    }

    render() {
        if (this.state.liked) {
            return 'You have liked';
        }

        return React.createElement(
            'button',
            {
                className: 'Test',
                onClick: () => this.setState({ liked: true }),                
            },
            'Like'
        );

    }
}

const buttonNode = document.getElementById('test');
ReactDOM.render(React.createElement(LikeButton), buttonNode);
