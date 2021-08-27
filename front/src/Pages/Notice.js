import Header from '../components/Header/Header';
import NoticeContents from '../components/NoticeContents/NoticeContents';
import Footer from '../components/Footer/Footer';


const Notice = ( {match} ) =>{
    return(
        <>
            <Header name={match.params.name}></Header>
            <NoticeContents></NoticeContents>
            <Footer></Footer>
        </>
    )
}

export default Notice;