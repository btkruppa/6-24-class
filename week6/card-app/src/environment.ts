const dev = {
    context: 'http://localhost:8012'
}

const prod = {
    context: 'http://cards-api.ppdksbfn6d.us-east-2.elasticbeanstalk.com'
}

export let environment = dev;

console.log(process.env.REACT_APP_ENV);

if (process.env.NODE_ENV === 'production' || process.env.REACT_APP_ENV === 'production') {
    environment = prod;
}