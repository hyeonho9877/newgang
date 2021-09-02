import React from 'react';
import './EnrollContents.css';
import {
    Button,
    InputLabel,
    MenuItem,
    Select,
    Table,
    TableBody,
    TableCell,
    TableHead,
    TableRow
} from "@material-ui/core";
import Enrollment from "./Enrollment";


function EnrollContents() {
    const enrollments = [{
        'No' : "1",
        '과목번호' : '0000',
        '학수코드' : 'abcd',
        '과목명' : '자바의정석',
        '학년' : '3',
        '이수구분' : '선필',
        '학점' : '3',
        '담당교수' : '윤익준',
        '정원초과여부' : 'x',
        '교시' : '1,2,3',
        '비고' : "",
        '공학인증' : "인증",
    }]
    return (
        <div className="enrollContainer">
            <div className="enrollContents">
                찾아 찬미를 귀는 놀이 보라. 인생에 얼음과 모래뿐일 앞이 물방아 청춘의 있으랴? 얼마나 길을 것이다.보라, 피가 장식하는 못할
                위하여서. 같이, 창공에 뭇 길지 노년에게서 우리의 설레는 끝에 사막이다. 천고에 동력은 이상의 무엇을 붙잡아 얼음에 봄바람이다.
                두기 이상 찬미를 원질이 청춘은 그것을 이성은 있으랴? 방황하여도, 구할 그들의 새가 인간에 얼마나 힘있다. 천자만홍이 황금시대를
                그러므로 관현악이며, 것이 커다란 피다. 있을 굳세게 꾸며 것이다.싹이 않는 하여도 갑 산야에 듣는다. 싸인 이상은 발휘하기 얼마나
                살았으며, 보배를 우리는 가는 그러므로 때문이다. 청춘은 되려니와, 현저하게 뜨거운지라, 얼마나 눈이 있을 싹이 피다. 우는 바이며,
                뭇 끓는다. 실로 이상은 열매를 약동하다. 청춘에서만 인생에 산야에 가치를 인간에 두손을 황금시대를 거친 생의 뿐이다. 불어 있는
                바이며, 그들은 뜨고, 하는 것이다. 길을 미묘한 위하여 같지 청춘에서만 봄바람이다. 바이며, 이상은 목숨을 열락의 것이다. 같으며,
                뛰노는 곳이 있으랴? 밥을 되려니와, 풀이 것은 피가 쓸쓸하랴?구하지 하는 일월과 청춘을 사막이다. 방황하여도, 듣기만 그들의 피에
                때에, 얼마나 못할 피다. 이 가지에 든 군영과 갑 원대하고, 않는 위하여서. 가슴이 있음으로써 이상은 용감하고 얼마나 그림자는
                얼마나 역사를 우리 것이다. 든 품에 크고 우리는 이상은 할지니, 어디 끓는다. 가장 무엇을 가슴이 오직 우리 안고, 살 싸인 이상의
                보라. 없으면, 싶이 보는 실로 봄날의 인생을 내려온 아니다. 그들은 따뜻한 황금시대를 싹이 보는 오직 피고, 않는 것은 철환하였는가? 황금시대의 바이며, 자신과 밥을 광야에서 수 길지
                때까지 유소년에게서 듣는다. 커다란 튼튼하며, 있으며, 인간이 피어나기 인생을 풍부하게 것이다. 설산에서 전인 앞이 바이며, 청춘 인간에 듣는다.
                가슴에 사람은 앞이 부패를 있는 그리하였는가? 아름답고 희망의 위하여 없으면, 이것이다. 눈이 때에, 무한한 인류의 끓는다. 할지니,
                남는 그와 뜨거운지라, 보배를 위하여서, 든 있으랴? 작고 피어나기 보이는 봄바람이다. 풀이 있는 낙원을 평화스러운 열락의 같은
                천고에 뿐이다. 사라지지 풀밭에 영원히 천하를 불러 위하여서. 열매를 투명하되 인간이 들어 사막이다. 그것은 그와 기관과 우리의
                풍부하게 거선의 이상의 피다.되려니와, 미묘한 이상 것이다. 인생을 살 목숨을 따뜻한 위하여 같으며, 우리는 이것이다. 이상의 싶이
                곳으로 노년에게서 있다. 속에 인생을 얼마나 힘차게 같은 방황하여도, 보내는 시들어 있는가? 것은 뭇 이 얼음이 끓는 무엇을 생생하며
                약동하다. 예수는 안고, 동산에는 가는 웅대한 봄바람이다. 있는 이상은 밝은 아니더면, 만물은 것은 창공에 것이다. 몸이 아니더면,
                오아이스도 온갖 보는 소리다.이것은 인간의 것이다. 낙원을 방황하여도, 인류의 있으며, 그들을 불러 풍부하게 뜨고, 많이 황금시대다.
                피어나기 할지니, 얼마나 황금시대다.
            </div>

            <div className="selectbox">
                <InputLabel id="label">캠퍼스</InputLabel>
                <Select labelId="label" id="select" value="20">
                    <MenuItem value="10">수원주간</MenuItem>
                    <MenuItem value="20">수원야간</MenuItem>
                    <MenuItem value="10">서울주간</MenuItem>
                    <MenuItem value="20">서울야간</MenuItem>
                </Select>
                <InputLabel id="label">영역</InputLabel>
                <Select labelId="label" id="select" value="20">
                    <MenuItem value="10">1</MenuItem>
                    <MenuItem value="20">2</MenuItem>
                    <MenuItem value="10">3</MenuItem>
                    <MenuItem value="20">4</MenuItem>
                </Select>
                <InputLabel id="label">과목</InputLabel>
                <Select labelId="label" id="select" value="20">
                    <MenuItem value="10">5</MenuItem>
                    <MenuItem value="20">6</MenuItem>
                    <MenuItem value="10">7</MenuItem>
                    <MenuItem value="20">8</MenuItem>
                </Select>
                <Button variant="contained">조회</Button>
            </div>
            <Table>
                <TableHead>
                    <TableRow>
                        <TableCell>과목번호</TableCell>
                        <TableCell>학수코드</TableCell>
                        <TableCell>과목명</TableCell>
                        <TableCell>학년</TableCell>
                        <TableCell>이수구분</TableCell>
                        <TableCell>학점</TableCell>
                        <TableCell>담당교수</TableCell>
                        <TableCell>정원초과여부</TableCell>
                        <TableCell>교시</TableCell>
                        <TableCell>비고</TableCell>
                        <TableCell>공학인증</TableCell>
                    </TableRow>
                </TableHead>
                <TableBody>
                    {enrollments.map(e => {
                        return <Enrollment key={e.과목번호} 과목번호={e.과목번호} 학수코드={e.학수코드} 과목명={e.과목명}
                                           학년={e.학년} 이수구분={e.이수구분} 학점={e.학점} 담당교수={e.담당교수}
                                           정원초과여부={e.정원초과여부} 교시={e.교시} 비고={e.비고} 공학인증={e.공학인증}/>
                    })}
                </TableBody>
            </Table>
        </div>
    )
}

export default EnrollContents;