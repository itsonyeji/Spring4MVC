<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<main>
    <h2>게시판</h2>
    <table class="board">
        <colgroup>
            <col style="width: 10%">
            <col style="">
            <col style="width: 15%">
            <col style="width: 15%">
            <col style="width: 10%">
        </colgroup>
        <tbody>
        <tr>
            <td colspan="2" class="alglft"> <%--align left--%>
                <select>
                    <option>제 목</option>
                    <option>작성자</option>
                    <option>본 문</option>
                </select>
                <input type="text">
                <button type="button" class="btn btn-dark">검색하기</button>
            </td>
            <%--            <td></td>--%><%--5개중 2개를 합쳐서,  하나는 주석처리해야함--%>
            <td colspan="3" class="btnrgt">
                <button type="button" id="newbtn" class="btn btn-success">새글쓰기</button>
            </td>
            <%--            <td></td>--%><%--마찬가지로 3개를 합쳤기 때문에 두개는 없애기--%>
            <%--            <td></td>--%>
        </tr>
            <td>1</td>
            <td><a href="/board/view?bno=">오늘은 그묘일이에여</a></td>
            <td>abc123</td>
            <td>2023-07-01</td>
            <td>987</td>
        </tr> <tr>
            <td>1</td>
            <td>오늘은 그묘일이에여</td>
            <td>abc123</td>
            <td>2023-07-01</td>
            <td>987</td>
        </tr> <tr>
            <td>1</td>
            <td>오늘은 그묘일이에여</td>
            <td>abc123</td>
            <td>2023-07-01</td>
            <td>987</td>
        </tr> <tr>
            <td>1</td>
            <td>오늘은 그묘일이에여</td>
            <td>abc123</td>
            <td>2023-07-01</td>
            <td>987</td>
        </tr> <tr>
            <td>1</td>
            <td>오늘은 그묘일이에여</td>
            <td>abc123</td>
            <td>2023-07-01</td>
            <td>987</td>
        </tr> <tr>
            <td>1</td>
            <td>오늘은 그묘일이에여</td>
            <td>abc123</td>
            <td>2023-07-01</td>
            <td>987</td>
        </tr> <tr>
            <td>1</td>
            <td>오늘은 그묘일이에여</td>
            <td>abc123</td>
            <td>2023-07-01</td>
            <td>987</td>
        </tr> <tr>
            <td>1</td>
            <td>오늘은 그묘일이에여</td>
            <td>abc123</td>
            <td>2023-07-01</td>
            <td>987</td>
        </tr> <tr>
            <td>1</td>
            <td>오늘은 그묘일이에여</td>
            <td>abc123</td>
            <td>2023-07-01</td>
            <td>987</td>
        </tr> <tr>
            <td>1</td>
            <td>오늘은 그묘일이에여</td>
            <td>abc123</td>
            <td>2023-07-01</td>
            <td>987</td>
        </tr> <tr>
            <td>1</td>
            <td>오늘은 그묘일이에여</td>
            <td>abc123</td>
            <td>2023-07-01</td>
            <td>987</td>
        </tr> <tr>
            <td>1</td>
            <td>오늘은 그묘일이에여</td>
            <td>abc123</td>
            <td>2023-07-01</td>
            <td>987</td>
        </tr> <tr>
            <td>1</td>
            <td>오늘은 그묘일이에여</td>
            <td>abc123</td>
            <td>2023-07-01</td>
            <td>987</td>
        </tr>
        </tbody>
    </table>
    <ul class="pagenation">
        <li>이전</li>
        <li class="cpage"><a href="?cpg=">1</a></li>
        <li><a href="?cpg=">2</a></li>
        <li><a href="?cpg=">3</a></li>
        <li><a href="?cpg=">4</a></li>
        <li><a href="?cpg=">5</a></li>
        <li><a href="?cpg=">6</a></li>
        <li><a href="?cpg=">7</a></li>
        <li><a href="?cpg=">8</a></li>
        <li><a href="?cpg=">9</a></li>
        <li><a href="?cpg=">10</a></li>
        <li>다음</li>
    </ul>
</main>
<script src="/assets/js/board.js"></script>