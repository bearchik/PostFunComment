package ut.ru.bearchik.plugin;

import org.junit.Test;
import ru.bearchik.plugin.api.MyPluginComponent;
import ru.bearchik.plugin.impl.MyPluginComponentImpl;

import static org.junit.Assert.assertEquals;

public class MyComponentUnitTest
{
    @Test
    public void testMyName()
    {
        MyPluginComponent component = new MyPluginComponentImpl(null);
        assertEquals("names do not match!", "myComponent",component.getName());
    }
}