package entities.components;

import entities.Component;

import java.util.UUID;

public class CameraComponent extends Component
{
    private int maxOffsetX;
    private int maxOffsetY;
    private int minOffsetX;
    private int minOffsetY;
    private int viewportWidth;
    private int viewportHeight;
    private UUID targetID;
}
