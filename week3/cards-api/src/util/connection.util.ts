import { Pool } from 'pg';

const connectionConfiguration = {
    user: process.env.CARD_DB_USERNAME,
    host: process.env.CARD_DB_URL || 'localhost',
    database: process.env.CARD_DB_NAME || 'card_api',
    password: process.env.CARD_DB_PASSWORD,
    port: +process.env.CARD_DB_PORT || 5432,
    max: 5
};

// console.log(connectionConfiguration);
export const connectionPool = new Pool(connectionConfiguration);