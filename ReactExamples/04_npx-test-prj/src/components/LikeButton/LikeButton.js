import React from "react";

//Класс
// export class LikeButton extends React.Component {

//     render() {
//         return (
//             <button onClick={this.props.onClick}>
//                 Like
//             </button>)
//     }
// }

//функциональный компонент
export const LikeButton = (props) => {
    return (
        <button onClick={props.onClick}>
            Like
        </button>
    );
};