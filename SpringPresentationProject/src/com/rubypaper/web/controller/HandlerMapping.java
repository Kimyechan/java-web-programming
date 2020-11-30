package com.rubypaper.web.controller;

import com.rubypaper.web.controller.board.*;
import com.rubypaper.web.controller.user.LoginController;
import com.rubypaper.web.controller.user.LogoutController;

import java.util.HashMap;
import java.util.Map;

public class HandlerMapping {
    private Map<String, Controller> mappings;

    public HandlerMapping() {
        // 모든 컨트롤러 객체를 Map에 등록한다
        mappings = new HashMap<String, Controller>();
        // USERS관련 컨트롤러 등록
        mappings.put("/login.do", new LoginController());
        mappings.put("/logout.do", new LogoutController());

        // BOARD 관련 컨트롤러 등록
        mappings.put("/getBoardList.do", new GetBoardListController());
        mappings.put("/insertBoard.do", new InsertBoardController());
        mappings.put("/updateBoard.do", new UpdateBoardController());
        mappings.put("/deleteBoard.do", new DeleteBoardController());
        mappings.put("/getBoard.do", new GetBoardController());
    }

    public Controller getController(String path) {
        // 매개변수로 받은 path에 해당하는 컨트롤러 객체를 검색하여 리턴한다.
        return mappings.get(path);
    }
}
