package api;

import java.io.IOException;

public class SetUp {
    Params params = new Params();
    RetrofitBuilder retrofitBuilder = new RetrofitBuilder();

    public String createBoard(String boardName) throws IOException {
        Params createdBoard = retrofitBuilder.getTrelloApi().createBoard(params, boardName).execute().body();
        return createdBoard.getId();
    }

    public String createList(String listName, String boardId) throws IOException {
        Params createdList = retrofitBuilder.getTrelloApi().createList(params, listName, boardId).execute().body();
        return createdList.getId();
    }

    public String createCard(String listId) throws IOException {
        Params createdCard = retrofitBuilder.getTrelloApi().createCard(params, listId).execute().body();
        return createdCard.getId();
    }

    public void addMember(String boardId) throws IOException {
        retrofitBuilder.getTrelloApi().addMember(boardId, "user95411438", params.getKey(), params.getToken(), "normal").execute().body();
    }

    public void archiveList(String listId) throws IOException {
        retrofitBuilder.getTrelloApi().archiveList(listId, params.getKey(), params.getToken(), "true").execute().body();
    }

    public String createLabel(String cardId, String color) throws IOException {
        Params createdLabel = retrofitBuilder.getTrelloApi().createLabelCard(params, cardId, color).execute().body();

        return createdLabel.getId();
    }
}
