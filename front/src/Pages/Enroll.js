import React from 'react';
import Header from '../components/Header/Header';
import EnrollContent from '../components/EnrollContents/EnrollContents';
import Footer from '../components/Footer/Footer';

const Enroll = ({ match }) => {
    return (
        <>
            <Header name={match.params.name}/>
            <EnrollContent></EnrollContent>
            <Footer/>
        </>
    );
}

export default Enroll;