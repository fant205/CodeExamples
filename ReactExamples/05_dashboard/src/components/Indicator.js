import React from "react";

export class Indicator extends React.Component {

    render() {


        return (
            <div className='element'>
                <div >
                    {this.props.obj.name}
                </div>
                <div >
                    <h2>
                        {this.props.obj.value}
                    </h2>
                </div>
            </div>
        )
    }
}