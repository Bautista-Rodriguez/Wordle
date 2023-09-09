import controller.WordleController;
import model.WordleModel;
import view.WordleView;

public class WordleMain {
    public static void main(String[] args) throws Exception {
        WordleModel model = new WordleModel();
        WordleView view = new WordleView(model);
        new WordleController(model,view);
        view.setFocusable(true);
        view.setVisible(true);
    }
}
