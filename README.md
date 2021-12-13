This application is a REST API that loads restaurants' data from csv files,
stores it in memory and returns the 5 best matches for the given input. 
In memory data storage was chosen for its simplicity and that can be changed 
without affecting the rest of the application.

# Requirements
- Docker
- Java 8+

# Build
To build the application, run the command below in a terminal:
```
./gradlew clean build
```

# Run
First, build the app image:
```
docker build -t restaurantapp .
```
When the image is ready, run it in a container:
```
docker run -p 80:8080 restaurantapp
```
The application is now ready to receive requests on `localhost/restaurants`.
# Test
To test the application, access the url `localhost/restaurants`. 
It will retrieve at most the best 5 matches considering the restaurants' attributes.
In order to filter the list of restaurants to be retrieved, the following query parameters are available:

| Parameter      | Description                                   | Possible values   |
| -----------    | --------------------------------------------- | ----------------- |
| name           | Name of the restaurant                        |      N/A          |
| cuisine        | Cuisine of the restaurant                     |      N/A          |
| distance       | Restaurant's distance from a defined location |    1~10 (miles)   |
| customerRating | Restaurant's customer rating                  |    1~5 (stars)    |
| averageCost    | Average cost of eat in the restaurant         |     10~50 ($)     |

For example, `localhost/restaurants?name=Fogo&distance=5` will retrieve all restaurants with 
name that contains "Fogo" and that are no further than 5 miles from a defined location. 