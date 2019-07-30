export default class User {
    constructor(
        public id = 0,
        public username = '',
        public password = '',
        public email = '',
        public firstName = '',
        public lastName = '',
        public phone = '',
        public role = ''
    ) {}
}