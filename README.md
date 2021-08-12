# 뉴강신청
### 경기대학교 수강신청의 새로운 패러다임을 제시.

# 회의 날짜
### 월, 금


## ● Members

신현호 (Spring Master) @[hyeonho9877](https://github.com/hyeonho9877)<br>
김도연 (Spring Master) @[joyfulviper](https://github.com/joyfulviper)<br>
<img src="https://img.shields.io/badge/React-61DAFB?style=flat-square&logo=React&logoColor=white"/>
이동엽 (React Master) @[ldongyeop2](https://github.com/ldongyeop2)


## ● Software Requirements
- 로그인을 통해 인증된 사용자만 수강신청 서비스에 접근할 수 있어야함
- 로그인의 최대 세션 유지 시간은 10분으로 제한한다.
- 로그인 성공시, 학생의 성명, 학년, 이수학기, 소속, 대학, 학과, 제한학점, 성적 우수자 여부, 공학인증 대상자 여부 및 로그아웃 버튼을 표시한다.
- 공지사항을 통해 공지사항을 전파할 수 있어야함
- 개설교과목 조회를 통해 현재 개설된 교과목을 조회할 수 있어야함.
- 개설교과목 조회는 교양, 전공, 교직, 연계(융합), ROTC, 일반대학원, 기타대학원, 외국어과목 탭별로 나누어져 있다.
- 개설교과목 중 교양 항목에 대한 조회는 캠퍼스, 영역, 과목을 선택해야 조회 할 수 있다.
- 개설교과목 중 전공 항목에 대한 조회는 캠퍼스, 대학, 학과, 전공을 선택해야 조회 할 수 있다.
- 전공 조회에 대해 캠퍼스, 대학, 학과, 전공에 대한 정보는 로그인한 학생 정보를 이용하여 초기화 한다.
- 소망가방 내역 조회를 통해 소망가방 신청 기간 중에 신청한 강의 정보를 조회할 수 있다.
- 소망가방 내역 조회를 통해 본과목 학점, 예비과목 학점, 시간표와 강의 정보가 표시된다.
- 소망가방 내역 조회를 통해 조회되는 강의별 정보는 신청번호, 일괄처리, 구분, 과목번호, 과목명, 교시, 이수구분, 학점, 담당교수, 변경사항, 재수강, 비고, 공학인증에 대한 정보가 표시된다.
- 수강신청 내역 조회를 통해 소망가방 신청 기간 중에 신청한 강의 정보를 조회할 수 있다.
- 수강신청 내역 조회를 통해 현재 신청학점, 시간표와 강의 정보가 표시된다.
- 수강신청 내역 조회를 통해 조회되는 강의별 정보는 신청번호, 일괄처리, 구분, 과목번호, 과목명, 교시, 이수구분, 학점, 담당교수, 변경사항, 재수강, 비고, 공학인증에 대한 정보가 표시된다.
- 수강신청은 수망가방, 교양, 전공, 교직, 연계(융합), ROTC, 일반대학원, 기타대학원, 외국어과목 탭별로 나누어져 있다.
- 수강신청 내에서 소망가방 탭은 자신이 이전에 신청한 소망가방 리스트가 표시되어야 한다.
- 수강신청 탭을 통해 조회한 강의별 정보는 번호, 신청, 과목번호, 학수코드, 과목명, 학년, 이수구분, 학점, 담당교수, 인원(대상학년), 인원(타학년), 인원(편입생), 교시, 비고, 공학인증에 대한 정보가 표시된다.
- 강의별 정보중 인원에 대한 정보는 '최대인원(현재 신청인원)'의 형태로 표시한다. 만약 현재 최대인원 보다 신청인원이 많은 경우 '최대인원(초과)'의 경우로 표시한다.
- 이를 제외한 탭은 위 조회 기능과 동일한 조건으로 개설 강좌를 검색할 수 있다.
- 수강신청 페이지의 하단에는 모든 탭에서 동일하게 수강신청 리스트를 확인할 수 있다.
- 수강신청 리스트에서 나타나는 정보는 수강신청 내역에서 각 강의별 정보와 동일하게 표시된다.
- 수강신청 리스트에서 과목번호를 직접 입력하여 수강신청을 진행할 수 있다.

## ● Demanded Web Page
- 로그인 페이지
- 수강신청 메인 (공지사항 탭)
- 개설교과목 조회
- 소망가방 내역조회
- 수강신청 내역조회
- 수강신청
- 소망가방 신청

# Getting Started with Create React App

This project was bootstrapped with [Create React App](https://github.com/facebook/create-react-app).

## Available Scripts

In the project directory, you can run:

### `npm start`

Runs the app in the development mode.\
Open [http://localhost:3000](http://localhost:3000) to view it in the browser.

The page will reload if you make edits.\
You will also see any lint errors in the console.

### `npm test`

Launches the test runner in the interactive watch mode.\
See the section about [running tests](https://facebook.github.io/create-react-app/docs/running-tests) for more information.

### `npm run build`

Builds the app for production to the `build` folder.\
It correctly bundles React in production mode and optimizes the build for the best performance.

The build is minified and the filenames include the hashes.\
Your app is ready to be deployed!

See the section about [deployment](https://facebook.github.io/create-react-app/docs/deployment) for more information.

### `npm run eject`

**Note: this is a one-way operation. Once you `eject`, you can’t go back!**

If you aren’t satisfied with the build tool and configuration choices, you can `eject` at any time. This command will remove the single build dependency from your project.

Instead, it will copy all the configuration files and the transitive dependencies (webpack, Babel, ESLint, etc) right into your project so you have full control over them. All of the commands except `eject` will still work, but they will point to the copied scripts so you can tweak them. At this point you’re on your own.

You don’t have to ever use `eject`. The curated feature set is suitable for small and middle deployments, and you shouldn’t feel obligated to use this feature. However we understand that this tool wouldn’t be useful if you couldn’t customize it when you are ready for it.

## Learn More

You can learn more in the [Create React App documentation](https://facebook.github.io/create-react-app/docs/getting-started).

To learn React, check out the [React documentation](https://reactjs.org/).
