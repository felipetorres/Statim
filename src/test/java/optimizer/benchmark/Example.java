package optimizer.benchmark;


public class Example {

	public static String matrix = "{" +
			"   \"destination_addresses\" : [" +
			"      \"R. Cananéia, 531-549 - Vila Prudente, São Paulo, 03132-040, República Federativa do Brasil\"," +
			"      \"R. Ribeiro Marcondes, 1 - Vila Prudente, São Paulo, 03132-120, República Federativa do Brasil\"," +
			"      \"R. Dr. Sanareli, 418-446 - Vila Prudente, São Paulo, 03137-100, República Federativa do Brasil\"," +
			"      \"R. Dr. Sanareli, 368-372 - Vila Prudente, São Paulo, 03137-100, República Federativa do Brasil\"," +
			"      \"R. Dr. Sanareli, 147-205 - Vila Prudente, São Paulo, 03137-100, República Federativa do Brasil\"" +
			"   ]," +
			"   \"origin_addresses\" : [" +
			"      \"R. Cananéia, 531-549 - Vila Prudente, São Paulo, 03132-040, República Federativa do Brasil\"," +
			"      \"R. Ribeiro Marcondes, 1 - Vila Prudente, São Paulo, 03132-120, República Federativa do Brasil\"," +
			"      \"R. Dr. Sanareli, 418-446 - Vila Prudente, São Paulo, 03137-100, República Federativa do Brasil\"," +
			"      \"R. Dr. Sanareli, 368-372 - Vila Prudente, São Paulo, 03137-100, República Federativa do Brasil\"," +
			"      \"R. Dr. Sanareli, 147-205 - Vila Prudente, São Paulo, 03137-100, República Federativa do Brasil\"" +
			"   ]," +
			"   \"rows\" : [" +
			"      {" +
			"" +
			"         \"elements\" : [" +
			"            {" +
			"               \"distance\" : {" +
			"                  \"text\" : \"1 m\"," +
			"                  \"value\" : 0" +
			"               }," +
			"               \"duration\" : {" +
			"                  \"text\" : \"1 min\"," +
			"                  \"value\" : 0" +
			"               }," +
			"               \"status\" : \"OK\"" +
			"            }," +
			"            {" +
			"               \"distance\" : {" +
			"                  \"text\" : \"0,7 km\"," +
			"                  \"value\" : 682" +
			"               }," +
			"               \"duration\" : {" +
			"                  \"text\" : \"2 minutos\"," +
			"                  \"value\" : 132" +
			"               }," +
			"               \"status\" : \"OK\"" +
			"            }," +
			"            {" +
			"               \"distance\" : {" +
			"                  \"text\" : \"0,5 km\"," +
			"                  \"value\" : 486" +
			"               }," +
			"               \"duration\" : {" +
			"                  \"text\" : \"2 minutos\"," +
			"                  \"value\" : 102" +
			"               }," +
			"               \"status\" : \"OK\"" +
			"            }," +
			"            {" +
			"               \"distance\" : {" +
			"                  \"text\" : \"0,4 km\"," +
			"                  \"value\" : 424" +
			"               }," +
			"               \"duration\" : {" +
			"                  \"text\" : \"1 min\"," +
			"                  \"value\" : 87" +
			"               }," +
			"               \"status\" : \"OK\"" +
			"            }," +
			"            {" +
			"               \"distance\" : {" +
			"                  \"text\" : \"0,2 km\"," +
			"                  \"value\" : 196" +
			"               }," +
			"               \"duration\" : {" +
			"                  \"text\" : \"1 min\"," +
			"                  \"value\" : 47" +
			"               }," +
			"               \"status\" : \"OK\"" +
			"            }" +
			"         ]" +
			"      }," +
			"      {" +
			"         \"elements\" : [" +
			"            {" +
			"               \"distance\" : {" +
			"                  \"text\" : \"0,4 km\"," +
			"                  \"value\" : 379" +
			"               }," +
			"               \"duration\" : {" +
			"                  \"text\" : \"1 min\"," +
			"                  \"value\" : 73" +
			"               }," +
			"               \"status\" : \"OK\"" +
			"            }," +
			"            {" +
			"               \"distance\" : {" +
			"                  \"text\" : \"1 m\"," +
			"                  \"value\" : 0" +
			"               }," +
			"               \"duration\" : {" +
			"                  \"text\" : \"1 min\"," +
			"                  \"value\" : 0" +
			"               }," +
			"               \"status\" : \"OK\"" +
			"            }," +
			"            {" +
			"               \"distance\" : {" +
			"                  \"text\" : \"0,9 km\"," +
			"                  \"value\" : 865" +
			"               }," +
			"               \"duration\" : {" +
			"                  \"text\" : \"3 minutos\"," +
			"                  \"value\" : 174" +
			"               }," +
			"               \"status\" : \"OK\"" +
			"" +
			"            }," +
			"            {" +
			"               \"distance\" : {" +
			"                  \"text\" : \"0,8 km\"," +
			"                  \"value\" : 803" +
			"               }," +
			"               \"duration\" : {" +
			"                  \"text\" : \"3 minutos\"," +
			"                  \"value\" : 159" +
			"               }," +
			"               \"status\" : \"OK\"" +
			"            }," +
			"            {" +
			"               \"distance\" : {" +
			"                  \"text\" : \"0,6 km\"," +
			"                  \"value\" : 575" +
			"               }," +
			"               \"duration\" : {" +
			"                  \"text\" : \"2 minutos\"," +
			"                  \"value\" : 120" +
			"               }," +
			"               \"status\" : \"OK\"" +
			"            }" +
			"         ]" +
			"      }," +
			"      {" +
			"         \"elements\" : [" +
			"            {" +
			"               \"distance\" : {" +
			"                  \"text\" : \"0,7 km\"," +
			"                  \"value\" : 714" +
			"               }," +
			"               \"duration\" : {" +
			"                  \"text\" : \"2 minutos\"," +
			"                  \"value\" : 148" +
			"               }," +
			"               \"status\" : \"OK\"" +
			"            }," +
			"            {" +
			"               \"distance\" : {" +
			"                  \"text\" : \"0,9 km\"," +
			"                  \"value\" : 945" +
			"               }," +
			"               \"duration\" : {" +
			"                  \"text\" : \"3 minutos\"," +
			"                  \"value\" : 189" +
			"               }," +
			"               \"status\" : \"OK\"" +
			"            }," +
			"            {" +
			"               \"distance\" : {" +
			"                  \"text\" : \"1 m\"," +
			"                  \"value\" : 0" +
			"               }," +
			"               \"duration\" : {" +
			"                  \"text\" : \"1 min\"," +
			"                  \"value\" : 0" +
			"               }," +
			"               \"status\" : \"OK\"" +
			"            }," +
			"            {" +
			"               \"distance\" : {" +
			"                  \"text\" : \"1,1 km\"," +
			"                  \"value\" : 1138" +
			"               }," +
			"               \"duration\" : {" +
			"                  \"text\" : \"4 minutos\"," +
			"                  \"value\" : 235" +
			"               }," +
			"               \"status\" : \"OK\"" +
			"            }," +
			"            {" +
			"               \"distance\" : {" +
			"                  \"text\" : \"0,9 km\"," +
			"                  \"value\" : 909" +
			"               }," +
			"               \"duration\" : {" +
			"                  \"text\" : \"3 minutos\"," +
			"                  \"value\" : 195" +
			"               }," +
			"               \"status\" : \"OK\"" +
			"            }" +
			"         ]" +
			"      }," +
			"      {" +
			"         \"elements\" : [" +
			"            {" +
			"               \"distance\" : {" +
			"                  \"text\" : \"0,8 km\"," +
			"                  \"value\" : 776" +
			"               }," +
			"               \"duration\" : {" +
			"                  \"text\" : \"3 minutos\"," +
			"                  \"value\" : 163" +
			"               }," +
			"               \"status\" : \"OK\"" +
			"            }," +
			"            {" +
			"               \"distance\" : {" +
			"                  \"text\" : \"1,0 km\"," +
			"                  \"value\" : 1007" +
			"               }," +
			"               \"duration\" : {" +
			"                  \"text\" : \"3 minutos\"," +
			"                  \"value\" : 204" +
			"               }," +
			"               \"status\" : \"OK\"" +
			"            }," +
			"            {" +
			"               \"distance\" : {" +
			"                  \"text\" : \"62 m\"," +
			"                  \"value\" : 62" +
			"               }," +
			"               \"duration\" : {" +
			"                  \"text\" : \"1 min\"," +
			"                  \"value\" : 15" +
			"               }," +
			"               \"status\" : \"OK\"" +
			"            }," +
			"            {" +
			"               \"distance\" : {" +
			"                  \"text\" : \"1 m\"," +
			"                  \"value\" : 0" +
			"               }," +
			"               \"duration\" : {" +
			"                  \"text\" : \"1 min\"," +
			"                  \"value\" : 0" +
			"               }," +
			"               \"status\" : \"OK\"" +
			"            }," +
			"            {" +
			"               \"distance\" : {" +
			"                  \"text\" : \"0,7 km\"," +
			"                  \"value\" : 735" +
			"               }," +
			"               \"duration\" : {" +
			"                  \"text\" : \"3 minutos\"," +
			"                  \"value\" : 160" +
			"               }," +
			"               \"status\" : \"OK\"" +
			"            }" +
			"         ]" +
			"      }," +
			"      {" +
			"         \"elements\" : [" +
			"            {" +
			"               \"distance\" : {" +
			"                  \"text\" : \"0,5 km\"," +
			"                  \"value\" : 546" +
			"               }," +
			"               \"duration\" : {" +
			"                  \"text\" : \"2 minutos\"," +
			"                  \"value\" : 113" +
			"               }," +
			"               \"status\" : \"OK\"" +
			"            }," +
			"            {" +
			"               \"distance\" : {" +
			"                  \"text\" : \"0,8 km\"," +
			"                  \"value\" : 777" +
			"               }," +
			"               \"duration\" : {" +
			"                  \"text\" : \"3 minutos\"," +
			"                  \"value\" : 152" +
			"               }," +
			"               \"status\" : \"OK\"" +
			"            }," +
			"            {" +
			"               \"distance\" : {" +
			"                  \"text\" : \"0,3 km\"," +
			"                  \"value\" : 290" +
			"               }," +
			"               \"duration\" : {" +
			"                  \"text\" : \"1 min\"," +
			"                  \"value\" : 55" +
			"               }," +
			"               \"status\" : \"OK\"" +
			"            }," +
			"            {" +
			"               \"distance\" : {" +
			"                  \"text\" : \"0,2 km\"," +
			"                  \"value\" : 228" +
			"               }," +
			"               \"duration\" : {" +
			"                  \"text\" : \"1 min\"," +
			"                  \"value\" : 40" +
			"               }," +
			"               \"status\" : \"OK\"" +
			"            }," +
			"            {" +
			"               \"distance\" : {" +
			"                  \"text\" : \"1 m\"," +
			"                  \"value\" : 0" +
			"               }," +
			"               \"duration\" : {" +
			"                  \"text\" : \"1 min\"," +
			"                  \"value\" : 0" +
			"               }," +
			"               \"status\" : \"OK\"" +
			"            }" +
			"         ]" +
			"      }" +
			"   ]," +
			"   \"status\" : \"OK\"" +
			"}";
}
