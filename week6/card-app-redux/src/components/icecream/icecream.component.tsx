import React, { Component } from 'react';
import { FaArrowCircleLeft, FaArrowCircleRight } from 'react-icons/fa';
import { RouteComponentProps } from 'react-router';
import { Button, Card, CardBody, CardFooter, CardHeader, CardText, CardTitle, Col, Container, Row } from 'reactstrap';
import { cardClient } from '../../axios/card.client';

interface Props extends RouteComponentProps {

}

interface State {
    icecream: any[];
    page: number;
    totalPages: number;
}

export default class IcecreamDisplay extends Component<Props, State> {

    constructor(props: Props) {
        super(props);
        this.state = {
            icecream: [],
            page: 0,
            totalPages: 0
        }
    }

    componentDidMount = async () => {
        this.getIcecream(0);
    }

    getIcecream = async (page: number) => {
        let resp = await cardClient.get(`/icecream?page=${page}`)
        this.setState({
            icecream: resp.data.content,
            page,
            totalPages: resp.data.totalPages
        });
    }

    render() {
        return (
            <div>
                <Container>
                    <Row>
                        <Col>
                            <FaArrowCircleLeft className="clickable"
                                onClick={() => this.getIcecream(this.state.page-1)} />
                        </Col>
                        <Col>
                            {this.state.page + 1} of {this.state.totalPages}
                        </Col>
                        <Col>
                            <FaArrowCircleRight className="clickable" 
                                onClick={() => this.getIcecream(this.state.page+1)} />
                        </Col>
                    </Row>
                    <Row>
                        {
                            this.state.icecream.map(ele =>
                                <Col>
                                    <Card>
                                        <CardHeader>{ele.name}</CardHeader>
                                        <CardBody>
                                            <CardTitle>Brand: {ele.brand.name} </CardTitle>
                                            <hr></hr>
                                            <CardTitle>Flavors: </CardTitle>
                                            {
                                                ele.flavors.map((flavor: any) => <CardText>
                                                    {flavor.name}
                                                </CardText>)
                                            }
                                            <hr></hr>
                                            <CardTitle>Toppings: </CardTitle>
                                            {
                                                ele.toppings.map((topping: any) => <CardText>
                                                    {topping.name}
                                                </CardText>)
                                            }
                                        </CardBody>
                                    </Card>
                                </Col>)
                        }
                    </Row>
                </Container>

            </div>
        )
    }
}
