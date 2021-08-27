import Header from '../components/Header/Header';
import InquireContents from '../components/InquireContents/InquireContents';
import Footer from '../components/Footer/Footer';


const Notice = ( {match} ) =>{
    return(
        <>
            <Header name={match.params.name}></Header>
            <InquireContents></InquireContents>
            <Footer></Footer>
        </>
    )
}

export default Notice;