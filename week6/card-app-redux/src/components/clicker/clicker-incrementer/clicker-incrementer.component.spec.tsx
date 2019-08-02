import React from 'react';
import { shallow } from 'enzyme';
import ClickerIncrementer, { IClickerIncrementerProps } from './clicker-incrementer.component';
import { Button } from 'reactstrap';

describe('<ClickerIncrementer />', () => {
    let mockProps: IClickerIncrementerProps;

    beforeEach(() => {
        mockProps = {
            amount: 0,
            clicks: 0,
            increment: jest.fn(),
            renderAt: 0
        }
    })

    let testValues = [[1,3], [0,36], [27,12], [12,27], [500,302], [14,15], [15,16], [16,17], [15,15], [15, 14]];

    testValues.forEach(([clicks, renderAt]) => {
        it(`should only render the button if clicks is >= renderAt: clicks=${clicks} and renderAt = ${renderAt}` , () => {
            mockProps.clicks = clicks;
            mockProps.renderAt = renderAt;
            const incrementer = shallow(<ClickerIncrementer {...mockProps} />);
            if(clicks >= renderAt) {
                expect(incrementer.find(Button)).toHaveLength(1);
            } else {
                expect(incrementer.find(Button)).toHaveLength(0);
            }   
        })
    })

    let amountValues = [3,5,7,10,1000,235,1235123,3724,-12309];
    amountValues.forEach(value => {
        it(`should call the increment function with the amount specified, amount specified=${value}`, () => {
            mockProps.amount = value;
            const incrementer = shallow(<ClickerIncrementer {...mockProps} />);
            const button = incrementer.find(Button).first();
            button.simulate('click');
            button.simulate('click');
            button.simulate('click');
            expect(mockProps.increment).toBeCalledWith(value);
            expect(mockProps.increment).toHaveBeenCalledTimes(3);
        })
    })
    

    
})
