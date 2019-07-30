import express from 'express';
import bodyParser from 'body-parser';
import { usersRouter } from './routers/users.router';
import { cardsRouter } from './routers/cards.router';
import { sessionMiddleware } from './middleware/session.middleware';
import { authRouter } from './routers/auth.router';
import { gamesRouter } from './routers/games.router';

// specify the port will run on
const port = process.env.PORT || 8012;
const app = express();

/**
 * Loggin middleware
 * This callback will be invoked anytime a request is made
 * regardless of url or http method
 */
app.use((req, res, next) => {
    console.log(`request made with url: ${req.url} and method ${req.method}`);
    next(); // pass request on to search for the next piece of middleware
});

// set up body parser to convert json body to object stored on req.body
app.use(bodyParser.json());

// allow cross origins
app.use((req, resp, next) => {
    console.log(req.get('host'));
    resp.header('Access-Control-Allow-Origin', `${req.headers.origin}`);
    resp.header('Access-Control-Allow-Headers', 'Origin, X-Requested-With, Content-Type, Accept');
    resp.header('Access-Control-Allow-Credentials', 'true');
    resp.header('Access-Control-Allow-Methods', 'POST, GET, DELETE, PUT, PATCH');
    next();
  });

/**
 * Session middleware to give us access to req.session for session data
 */
app.use(sessionMiddleware);

/*******************************************
 * Register Routers
 ******************************************/
app.use('/users', usersRouter);
app.use('/cards', cardsRouter);
app.use('/games', gamesRouter);
app.use(authRouter);

app.listen(port, () => {
    console.log('app started on port: ' + port);
});