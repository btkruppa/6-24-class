# From what base image
# We will start with an image that has node 10 so we don't
# have to install node ourself
FROM node:10 

# copy the contents of this project from our host to the image
COPY . .

# install node dependencies
RUN npm install

# command that will run when the container is started
CMD [ "npm", "start"]