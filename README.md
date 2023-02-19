<a name="readme-top"></a>

<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#usage / demonstration">Usage and Demonstration</a></li>
    <li><a href="#improvements">Improvements</a></li>
    <li><a href="#license">License</a></li>
    <li><a href="#contact">Contact</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
# Jun Kai E-Commerce Shop (GovTech Assignment 2) BE - Kotlin

## About The Project

Create a React frontend in Typescript and Spring Boot web backend in Kotlin with the
following functionalities.
1. Upload a CSV file with appropriate feedback to the user on the upload progress.
2. List the data uploaded with pagination.
3. Search data from the uploaded file.

This project was bootstrapped with [Create React App](https://github.com/facebook/create-react-app).


<!-- GETTING STARTED -->

## Getting Started

Please follow the instructions below on setting up this project locally.

### Prerequisites

Please ensure that you run both FE and BE applications concurrently.

[https://github.com/Ong-Jun-Kai/assignment2-react.git](https://github.com/Ong-Jun-Kai/assignment2-react.git)

[https://github.com/Ong-Jun-Kai/assignment2-kotlin.git](https://github.com/Ong-Jun-Kai/assignment2-kotlin.git)


### Installation

Please installing and setting up your app with the following steps:

1. Clone the repo
   ```sh
   git clone https://github.com/Ong-Jun-Kai/assignment2-kotlin.git

   ```
   
2. In the project directory, open the file as below:

    _[Your path location]\assignment2-kotlin\src\main\kotlin\com\kotlinspring\assignment2kotlin\Assignment2KotlinApplication.kt_


3. Then, runs the app in the development mode.


4.  Open [http://localhost:8080/h2-console](http://localhost:8080/h2-console) to view the h2-console db



5. Login credentials of H2 console is:



* JDBC URL: jdbc:h2:~/data/ecommerce
* Username: sa
* Password: password

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- USAGE EXAMPLES -->

## Usage / Demonstration

### JWT API: _http://localhost:8080/authenticate_


### GET All E-commerce data API: _http://localhost:8080/getAllECommerce?searchQuery=&sort=&page=&size=_

* You can get a list of e-commerce data returned using this API
* Headers key and value:

    1. Origin: http://localhost:3000

================================================================================

### File Upload API: _http://localhost:8080/uploads_

* You can either do the file upload using Postman or via the UI button.
* If you are using Postman, please select the form-data with file type in order to upload a csv file
* Headers key and value:

    1. Origin: http://localhost:3000

================================================================================


<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- IMPROVEMENTS -->

## Improvements

I would like to enhance this project in the future such as following:

1. Implement more unit testing using jUnit
2. Rest API response message
3. Better error handling for REST
4. Expedite the upload process, currently took around 30 secs to upload data.csv which has approximately 500k records

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- CONTACT -->

## Contact

If you have a better suggestion or further comments on this project, please do not hesitate to contact me in person or
via the channels below.
Don't forget to give the project a star! Thanks again!

Jun Kai - [@my_LinkedIn](https://www.linkedin.com/in/jun-kai-ong-1b222518b) - ongjunkai@ecquaria.com

Project Link: [https://github.com/Ong-Jun-Kai/assignment2-kotlin.git](https://github.com/Ong-Jun-Kai/assignment2-kotlin.git)

<p align="right">(<a href="#readme-top">back to top</a>)</p>








