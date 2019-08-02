import axios from 'axios';
import { environment } from '../environment';

export const cardClient = axios.create({
    baseURL: environment.context,
    withCredentials: true
});
