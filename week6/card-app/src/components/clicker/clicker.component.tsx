import React from 'react';
import ClickerDisplay from './clicker-display/clicker-display.component';
import ClickerIncrementer from './clicker-incrementer/clicker-incrementer.component';


interface IClickerState {
    clicks: number
}

export class Clicker extends React.Component<{}, IClickerState> {
    state = {
        clicks: 20
    }

    increment = (amount: number) => {
        this.setState({
            clicks: this.state.clicks + amount
        });
    }

    render() {
        const { clicks } = this.state;
        return (
            <div>
                <ClickerDisplay clicks={clicks} />
                <ClickerIncrementer amount={3} clicks={clicks}
                    increment={this.increment} renderAt={0} />

                <ClickerIncrementer amount={4} clicks={clicks}
                    increment={this.increment} renderAt={36} />

                <ClickerIncrementer amount={5} clicks={clicks}
                    increment={this.increment} renderAt={40} />

                <ClickerIncrementer amount={1000} clicks={clicks}
                    increment={this.increment} renderAt={100} />
            </div>
        );
    }
}
