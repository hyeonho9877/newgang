import {TableCell, TableRow} from "@material-ui/core";

function Enrollment( { 공학인증, 비고, 과목명, 과목번호, 교시, 담당교수, 이수구분, 정원초과여부, 학년, 학수코드, 학점} ) {
    return(
        <TableRow>
            <TableCell>{과목번호}</TableCell>
            <TableCell>{학수코드}</TableCell>
            <TableCell>{과목명}</TableCell>
            <TableCell>{학년}</TableCell>
            <TableCell>{이수구분}</TableCell>
            <TableCell>{학점}</TableCell>
            <TableCell>{담당교수}</TableCell>
            <TableCell>{정원초과여부}</TableCell>
            <TableCell>{교시}</TableCell>
            <TableCell>{비고}</TableCell>
            <TableCell>{공학인증}</TableCell>
        </TableRow>
    )
}
export default Enrollment;