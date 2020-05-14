import api.ApiRequest;
import api.SetUp;
import ui.DriverWrapper;
import ui.UiRequest;

public class Values {
    protected String boardId;
    protected String listId;
    protected String cardId;
    protected String labelId;
    protected String boardName = "Board" + (Math.random() * 1000);
    protected String listName = "List" + (Math.random() * 100);
    protected String color = "green";
    ApiRequest response = new ApiRequest();
    final DriverWrapper driverWrapper = new DriverWrapper();
    protected UiRequest uiRequest;
    protected SetUp setUp = new SetUp();
}
