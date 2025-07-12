package presentation.ente;

import entes.ln.StateSerVivo;
import presentation.main.PDefaultValues;
import turner.md.enums.TurnerEnumConstant;

public enum AbstractFactoryGraphicCharacterEnums {

	
	G_OSCAR_NORMAL(AbstractFactoryCharacterEnums.OSCAR_NORMAL,
			PDefaultValues.getPathImage("bluesky.png")),
	G_JIJI_NORMAL(AbstractFactoryCharacterEnums.JIJI_NORMAL,
			PDefaultValues.getPathImage("Iuqos.png"));

			
	private final AbstractFactoryCharacterEnums character;
    private final String pathImage;

    // Constructor del enum
    AbstractFactoryGraphicCharacterEnums(AbstractFactoryCharacterEnums character, String pathImage) {
        this.character = character;
        this.pathImage = pathImage;
    }

    // Métodos para obtener los valores
    public AbstractFactoryCharacterEnums getCharacter() {
        return character;
    }

    public String getPathImage() {
        return pathImage;
    }
}
