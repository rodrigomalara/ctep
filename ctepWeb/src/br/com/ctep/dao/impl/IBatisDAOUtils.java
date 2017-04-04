package br.com.ctep.dao.impl;


public class IBatisDAOUtils {

	protected static String PREFIXO_SQL = "br.com.ctep.entidades";
	
	protected static String pegaPrefixo(Class<?> clazz) {
		return clazz.getName().substring(PREFIXO_SQL.length() + 1) + ".";
	}
	
    /**
     * @return Returns the select query name.
     */
    public static String pegaComandoSelect(Class<?> clazz) {
        return pegaPrefixo(clazz) + "lista" + clazz.getSimpleName() + "s";
    }
    
    /**
     * @return Returns the select query name.
     */
    public static String pegaComandoSelectPorExemplo(Class<?> clazz) {
        return pegaPrefixo(clazz) + "lista" + clazz.getSimpleName() + "sPorExemplo";
    }

    /**
     * @return Returns the find query name.
     */
    public static String pegaComandoSelectPK(Class<?> clazz) {
        return pegaPrefixo(clazz) + "pega" + clazz.getSimpleName();
    }

    /**
     * @return Returns the insert query name.
     */
    public static String pegaComandoInsert(Class<?> clazz) {
        return pegaPrefixo(clazz) + "insere" + clazz.getSimpleName();
    }

    /**
     * @return Returns the update query name.
     */
    public static String pegaComandoUpdate(Class<?> clazz) {
        return pegaPrefixo(clazz) + "atualiza" + clazz.getSimpleName();
    }

    /**
     * @return Returns the delete query name.
     */
    public static String pegaComandoDelete(Class<?> clazz) {
        return pegaPrefixo(clazz) + "apaga" + clazz.getSimpleName();
    }
    
    /**
     * @return Returns the select query name.
     */
    public static String pegaComandoContaTodos(Class<?> clazz) {
        return pegaPrefixo(clazz) + "conta" + clazz.getSimpleName() + "s";
    }
    
    /**
     * @return Returns the select query name.
     */
    public static String pegaComandoContaTodosPorExemplo(Class<?> clazz) {
        return pegaPrefixo(clazz) + "conta" + clazz.getSimpleName() + "sPorExemplo";
    }
}
