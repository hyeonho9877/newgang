import './InquireContents.css';
import {
    Table,
    TableBody,
    TableCell,
    TableHead,
    TableRow,
    Button,
    InputLabel,
    Select,
    MenuItem
} from "@material-ui/core";
import Enrollment from "../EnrollContents/Enrollment";
import React from "react";

function InquireContents() {
    const enrollments = [{
        'No': "1",
        '과목번호': '0000',
        '학수코드': 'abcd',
        '과목명': '자바의정석',
        '학년': '3',
        '이수구분': '선필',
        '학점': '3',
        '담당교수': '윤익준',
        '정원초과여부': 'x',
        '교시': '1,2,3',
        '비고': "",
        '공학인증': "인증",
    }]
    return (
        <div className="enrollContainer">
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

export default InquireContents;