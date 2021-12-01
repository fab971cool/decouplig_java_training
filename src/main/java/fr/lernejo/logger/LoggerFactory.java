package fr.lernejo.logger;

public class LoggerFactory
{
    static public Logger getLogger( String name)
    {
        return new ConsoleLogger();
    }
}
