import React, { Component } from 'react'

interface Props {
    clicks: number
}

export default class ClickerDisplay extends Component<Props> {

    colorCheck() {
        const clicks = this.props.clicks;
        if (clicks % 6 === 0) {
            return 'yellow';
        } else if(clicks % 7 === 0) {
            return 'red';
        } else {
            return 'green';
        }
    }

    render() {
        const clicks = this.props.clicks;
        return (
            <h3 className={this.colorCheck()}>Clicks: {clicks} </h3>
        )
    }
}
