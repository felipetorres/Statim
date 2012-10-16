package optimizer.benchmark;


public class Example {

	public static String matrix = "{" +
			"   \"destination_addresses\" : [" +
			"      \"R. Cananeia, 531-549 - Vila Prudente, Sao Paulo, 03132-040, Republica Federativa do Brasil\"," +
			"      \"R. Ribeiro Marcondes, 1 - Vila Prudente, Sao Paulo, 03132-120, Republica Federativa do Brasil\"," +
			"      \"R. Dr. Sanareli, 418-446 - Vila Prudente, Sao Paulo, 03137-100, Republica Federativa do Brasil\"," +
			"      \"R. Dr. Sanareli, 368-372 - Vila Prudente, Sao Paulo, 03137-100, Republica Federativa do Brasil\"," +
			"      \"R. Dr. Sanareli, 147-205 - Vila Prudente, Sao Paulo, 03137-100, Republica Federativa do Brasil\"" +
			"   ]," +
			"   \"origin_addresses\" : [" +
			"      \"R. Cananeia, 531-549 - Vila Prudente, Sao Paulo, 03132-040, Republica Federativa do Brasil\"," +
			"      \"R. Ribeiro Marcondes, 1 - Vila Prudente, Sao Paulo, 03132-120, Republica Federativa do Brasil\"," +
			"      \"R. Dr. Sanareli, 418-446 - Vila Prudente, Sao Paulo, 03137-100, Republica Federativa do Brasil\"," +
			"      \"R. Dr. Sanareli, 368-372 - Vila Prudente, Sao Paulo, 03137-100, Republica Federativa do Brasil\"," +
			"      \"R. Dr. Sanareli, 147-205 - Vila Prudente, Sao Paulo, 03137-100, Republica Federativa do Brasil\"" +
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
	
		public static String matrix2 = "{   \"destination_addresses\" : [      \"R. Torquato Tasso, 956-998 - Vila Prudente, Sao Paulo, 03136-030, Republica Federativa do Brasil\",      \"R. Itanhaem, 255-277 - Vila Prudente, Sao Paulo, 03137-020, Republica Federativa do Brasil\",      \"R. Torquato Tasso, 722-724 - Vila Prudente, Sao Paulo, 03136-030, Republica Federativa do Brasil\",      \"R. Torquato Tasso, 870 - Vila Prudente, Sao Paulo, 03136-030, Republica Federativa do Brasil\",      \"R. Torquato Tasso, 724-758 - Vila Prudente, Sao Paulo, 03136-030, Republica Federativa do Brasil\",      \"R. Torquato Tasso, 826 - Vila Prudente, Sao Paulo, 03136-030, Republica Federativa do Brasil\",      \"R. Itanhaem, 323 - Vila Prudente, Sao Paulo, 03137-020, Republica Federativa do Brasil\",      \"R. Torquato Tasso, 506 - Vila Prudente, Sao Paulo, 03136-030, Republica Federativa do Brasil\",      \"R. Torquato Tasso, 576-632 - Vila Prudente, Sao Paulo, 03136-030, Republica Federativa do Brasil\",      \"R. Torquato Tasso, 956-998 - Vila Prudente, Sao Paulo, 03136-030, Republica Federativa do Brasil\"   ],   \"origin_addresses\" : [      \"R. Torquato Tasso, 956-998 - Vila Prudente, Sao Paulo, 03136-030, Republica Federativa do Brasil\",      \"R. Itanhaem, 255-277 - Vila Prudente, Sao Paulo, 03137-020, Republica Federativa do Brasil\",      \"R. Torquato Tasso, 722-724 - Vila Prudente, Sao Paulo, 03136-030, Republica Federativa do Brasil\",      \"R. Torquato Tasso, 870 - Vila Prudente, Sao Paulo, 03136-030, Republica Federativa do Brasil\",      \"R. Torquato Tasso, 724-758 - Vila Prudente, Sao Paulo, 03136-030, Republica Federativa do Brasil\",      \"R. Torquato Tasso, 826 - Vila Prudente, Sao Paulo, 03136-030, Republica Federativa do Brasil\",      \"R. Itanhaem, 323 - Vila Prudente, Sao Paulo, 03137-020, Republica Federativa do Brasil\",      \"R. Torquato Tasso, 506 - Vila Prudente, Sao Paulo, 03136-030, Republica Federativa do Brasil\",      \"R. Torquato Tasso, 576-632 - Vila Prudente, Sao Paulo, 03136-030, Republica Federativa do Brasil\",      \"R. Torquato Tasso, 956-998 - Vila Prudente, Sao Paulo, 03136-030, Republica Federativa do Brasil\"   ],   \"rows\" : [      {         \"elements\" : [            {               \"distance\" : {                  \"text\" : \"1 m\",                  \"value\" : 0               },               \"duration\" : {                  \"text\" : \"1 min\",                  \"value\" : 0               },               \"status\" : \"OK\"            },            {               \"distance\" : {                  \"text\" : \"0,3 km\",                  \"value\" : 267               },               \"duration\" : {                  \"text\" : \"1 min\",                  \"value\" : 59               },               \"status\" : \"OK\"            },            {               \"distance\" : {                  \"text\" : \"0,3 km\",                  \"value\" : 261               },               \"duration\" : {                  \"text\" : \"1 min\",                  \"value\" : 56               },               \"status\" : \"OK\"            },            {               \"distance\" : {                  \"text\" : \"76 m\",                  \"value\" : 76               },               \"duration\" : {                  \"text\" : \"1 min\",                  \"value\" : 17               },               \"status\" : \"OK\"            },            {               \"distance\" : {                  \"text\" : \"0,2 km\",                  \"value\" : 202               },               \"duration\" : {                  \"text\" : \"1 min\",                  \"value\" : 47               },               \"status\" : \"OK\"            },            {               \"distance\" : {                  \"text\" : \"0,1 km\",                  \"value\" : 118               },               \"duration\" : {                  \"text\" : \"1 min\",                  \"value\" : 29               },               \"status\" : \"OK\"            },            {               \"distance\" : {                  \"text\" : \"0,5 km\",                  \"value\" : 488               },               \"duration\" : {                  \"text\" : \"2 minutos\",                  \"value\" : 98               },               \"status\" : \"OK\"            },            {               \"distance\" : {                  \"text\" : \"0,4 km\",                  \"value\" : 432               },               \"duration\" : {                  \"text\" : \"2 minutos\",                  \"value\" : 92               },               \"status\" : \"OK\"            },            {               \"distance\" : {                  \"text\" : \"0,4 km\",                  \"value\" : 350               },               \"duration\" : {                  \"text\" : \"1 min\",                  \"value\" : 74               },               \"status\" : \"OK\"            },            {               \"distance\" : {                  \"text\" : \"0,3 km\",                  \"value\" : 339               },               \"duration\" : {                  \"text\" : \"1 min\",                  \"value\" : 77               },               \"status\" : \"OK\"            }         ]      },      {         \"elements\" : [            {               \"distance\" : {                  \"text\" : \"0,1 km\",                  \"value\" : 117               },               \"duration\" : {                  \"text\" : \"1 min\",                  \"value\" : 24               },               \"status\" : \"OK\"            },            {               \"distance\" : {                  \"text\" : \"1 m\",                  \"value\" : 0               },               \"duration\" : {                  \"text\" : \"1 min\",                  \"value\" : 0               },               \"status\" : \"OK\"            },            {               \"distance\" : {                  \"text\" : \"0,4 km\",                  \"value\" : 378               },               \"duration\" : {                  \"text\" : \"1 min\",                  \"value\" : 79               },               \"status\" : \"OK\"            },            {               \"distance\" : {                  \"text\" : \"0,2 km\",                  \"value\" : 193               },               \"duration\" : {                  \"text\" : \"1 min\",                  \"value\" : 41               },               \"status\" : \"OK\"            },            {               \"distance\" : {                  \"text\" : \"0,3 km\",                  \"value\" : 319               },               \"duration\" : {                  \"text\" : \"1 min\",                  \"value\" : 71               },               \"status\" : \"OK\"            },            {               \"distance\" : {                  \"text\" : \"0,2 km\",                  \"value\" : 235               },               \"duration\" : {                  \"text\" : \"1 min\",                  \"value\" : 53               },               \"status\" : \"OK\"            },            {               \"distance\" : {                  \"text\" : \"0,6 km\",                  \"value\" : 605               },               \"duration\" : {                  \"text\" : \"2 minutos\",                  \"value\" : 122               },               \"status\" : \"OK\"            },            {               \"distance\" : {                  \"text\" : \"0,5 km\",                  \"value\" : 549               },               \"duration\" : {                  \"text\" : \"2 minutos\",                  \"value\" : 116               },               \"status\" : \"OK\"            },            {               \"distance\" : {                  \"text\" : \"0,5 km\",                  \"value\" : 467               },               \"duration\" : {                  \"text\" : \"2 minutos\",                  \"value\" : 98               },               \"status\" : \"OK\"            },            {               \"distance\" : {                  \"text\" : \"71 m\",                  \"value\" : 71               },               \"duration\" : {                  \"text\" : \"1 min\",                  \"value\" : 17               },               \"status\" : \"OK\"            }         ]      },      {         \"elements\" : [            {               \"distance\" : {                  \"text\" : \"0,6 km\",                  \"value\" : 648               },               \"duration\" : {                  \"text\" : \"2 minutos\",                  \"value\" : 134               },               \"status\" : \"OK\"            },            {               \"distance\" : {                  \"text\" : \"0,5 km\",                  \"value\" : 530               },               \"duration\" : {                  \"text\" : \"2 minutos\",                  \"value\" : 110               },               \"status\" : \"OK\"            },            {               \"distance\" : {                  \"text\" : \"1 m\",                  \"value\" : 0               },               \"duration\" : {                  \"text\" : \"1 min\",                  \"value\" : 0               },               \"status\" : \"OK\"            },            {               \"distance\" : {                  \"text\" : \"0,7 km\",                  \"value\" : 723               },               \"duration\" : {                  \"text\" : \"3 minutos\",                  \"value\" : 151               },               \"status\" : \"OK\"            },            {               \"distance\" : {                  \"text\" : \"0,4 km\",                  \"value\" : 383               },               \"duration\" : {                  \"text\" : \"1 min\",                  \"value\" : 83               },               \"status\" : \"OK\"            },            {               \"distance\" : {                  \"text\" : \"0,4 km\",                  \"value\" : 439               },               \"duration\" : {                  \"text\" : \"2 minutos\",                  \"value\" : 92               },               \"status\" : \"OK\"            },            {               \"distance\" : {                  \"text\" : \"0,8 km\",                  \"value\" : 752               },               \"duration\" : {                  \"text\" : \"3 minutos\",                  \"value\" : 154               },               \"status\" : \"OK\"            },            {               \"distance\" : {                  \"text\" : \"0,2 km\",                  \"value\" : 171               },               \"duration\" : {                  \"text\" : \"1 min\",                  \"value\" : 37               },               \"status\" : \"OK\"            },            {               \"distance\" : {                  \"text\" : \"89 m\",                  \"value\" : 89               },               \"duration\" : {                  \"text\" : \"1 min\",                  \"value\" : 19               },               \"status\" : \"OK\"            },            {               \"distance\" : {                  \"text\" : \"0,6 km\",                  \"value\" : 602               },               \"duration\" : {                  \"text\" : \"2 minutos\",                  \"value\" : 128               },               \"status\" : \"OK\"            }         ]      },      {         \"elements\" : [            {               \"distance\" : {                  \"text\" : \"0,4 km\",                  \"value\" : 438               },               \"duration\" : {                  \"text\" : \"2 minutos\",                  \"value\" : 97               },               \"status\" : \"OK\"            },            {               \"distance\" : {                  \"text\" : \"0,3 km\",                  \"value\" : 321               },               \"duration\" : {                  \"text\" : \"1 min\",                  \"value\" : 73               },               \"status\" : \"OK\"            },            {               \"distance\" : {                  \"text\" : \"0,2 km\",                  \"value\" : 185               },               \"duration\" : {                  \"text\" : \"1 min\",                  \"value\" : 39               },               \"status\" : \"OK\"            },            {               \"distance\" : {                  \"text\" : \"1 m\",                  \"value\" : 0               },               \"duration\" : {                  \"text\" : \"1 min\",                  \"value\" : 0               },               \"status\" : \"OK\"            },            {               \"distance\" : {                  \"text\" : \"0,1 km\",                  \"value\" : 126               },               \"duration\" : {                  \"text\" : \"1 min\",                  \"value\" : 30               },               \"status\" : \"OK\"            },            {               \"distance\" : {                  \"text\" : \"42 m\",                  \"value\" : 42               },               \"duration\" : {                  \"text\" : \"1 min\",                  \"value\" : 12               },               \"status\" : \"OK\"            },            {               \"distance\" : {                  \"text\" : \"0,5 km\",                  \"value\" : 542               },               \"duration\" : {                  \"text\" : \"2 minutos\",                  \"value\" : 114               },               \"status\" : \"OK\"            },            {               \"distance\" : {                  \"text\" : \"0,4 km\",                  \"value\" : 356               },               \"duration\" : {                  \"text\" : \"1 min\",                  \"value\" : 75               },               \"status\" : \"OK\"            },            {               \"distance\" : {                  \"text\" : \"0,3 km\",                  \"value\" : 274               },               \"duration\" : {                  \"text\" : \"1 min\",                  \"value\" : 57               },               \"status\" : \"OK\"            },            {               \"distance\" : {                  \"text\" : \"0,4 km\",                  \"value\" : 393               },               \"duration\" : {                  \"text\" : \"2 minutos\",                  \"value\" : 91               },               \"status\" : \"OK\"            }         ]      },      {         \"elements\" : [            {               \"distance\" : {                  \"text\" : \"0,7 km\",                  \"value\" : 707               },               \"duration\" : {                  \"text\" : \"2 minutos\",                  \"value\" : 143               },               \"status\" : \"OK\"            },            {               \"distance\" : {                  \"text\" : \"0,6 km\",                  \"value\" : 590               },               \"duration\" : {                  \"text\" : \"2 minutos\",                  \"value\" : 119               },               \"status\" : \"OK\"            },            {               \"distance\" : {                  \"text\" : \"59 m\",                  \"value\" : 59               },               \"duration\" : {                  \"text\" : \"1 min\",                  \"value\" : 9               },               \"status\" : \"OK\"            },            {               \"distance\" : {                  \"text\" : \"0,8 km\",                  \"value\" : 782               },               \"duration\" : {                  \"text\" : \"3 minutos\",                  \"value\" : 160               },               \"status\" : \"OK\"            },            {               \"distance\" : {                  \"text\" : \"1 m\",                  \"value\" : 0               },               \"duration\" : {                  \"text\" : \"1 min\",                  \"value\" : 0               },               \"status\" : \"OK\"            },            {               \"distance\" : {                  \"text\" : \"0,5 km\",                  \"value\" : 498               },               \"duration\" : {                  \"text\" : \"2 minutos\",                  \"value\" : 101               },               \"status\" : \"OK\"            },            {               \"distance\" : {                  \"text\" : \"0,8 km\",                  \"value\" : 811               },               \"duration\" : {                  \"text\" : \"3 minutos\",                  \"value\" : 163               },               \"status\" : \"OK\"            },            {               \"distance\" : {                  \"text\" : \"0,2 km\",                  \"value\" : 230               },               \"duration\" : {                  \"text\" : \"1 min\",                  \"value\" : 45               },               \"status\" : \"OK\"            },            {               \"distance\" : {                  \"text\" : \"0,1 km\",                  \"value\" : 148               },               \"duration\" : {                  \"text\" : \"1 min\",                  \"value\" : 27               },               \"status\" : \"OK\"            },            {               \"distance\" : {                  \"text\" : \"0,7 km\",                  \"value\" : 661               },               \"duration\" : {                  \"text\" : \"2 minutos\",                  \"value\" : 136               },               \"status\" : \"OK\"            }         ]      },      {         \"elements\" : [            {               \"distance\" : {                  \"text\" : \"0,8 km\",                  \"value\" : 791               },               \"duration\" : {                  \"text\" : \"3 minutos\",                  \"value\" : 161               },               \"status\" : \"OK\"            },            {               \"distance\" : {                  \"text\" : \"0,7 km\",                  \"value\" : 674               },               \"duration\" : {                  \"text\" : \"2 minutos\",                  \"value\" : 137               },               \"status\" : \"OK\"            },            {               \"distance\" : {                  \"text\" : \"0,1 km\",                  \"value\" : 143               },               \"duration\" : {                  \"text\" : \"1 min\",                  \"value\" : 27               },               \"status\" : \"OK\"            },            {               \"distance\" : {                  \"text\" : \"0,7 km\",                  \"value\" : 699               },               \"duration\" : {                  \"text\" : \"2 minutos\",                  \"value\" : 142               },               \"status\" : \"OK\"            },            {               \"distance\" : {                  \"text\" : \"84 m\",                  \"value\" : 84               },               \"duration\" : {                  \"text\" : \"1 min\",                  \"value\" : 18               },               \"status\" : \"OK\"            },            {               \"distance\" : {                  \"text\" : \"1 m\",                  \"value\" : 0               },               \"duration\" : {                  \"text\" : \"1 min\",                  \"value\" : 0               },               \"status\" : \"OK\"            },            {               \"distance\" : {                  \"text\" : \"0,9 km\",                  \"value\" : 895               },               \"duration\" : {                  \"text\" : \"3 minutos\",                  \"value\" : 181               },               \"status\" : \"OK\"            },            {               \"distance\" : {                  \"text\" : \"0,3 km\",                  \"value\" : 314               },               \"duration\" : {                  \"text\" : \"1 min\",                  \"value\" : 63               },               \"status\" : \"OK\"            },            {               \"distance\" : {                  \"text\" : \"0,2 km\",                  \"value\" : 232               },               \"duration\" : {                  \"text\" : \"1 min\",                  \"value\" : 45               },               \"status\" : \"OK\"            },            {               \"distance\" : {                  \"text\" : \"0,7 km\",                  \"value\" : 745               },               \"duration\" : {                  \"text\" : \"3 minutos\",                  \"value\" : 154               },               \"status\" : \"OK\"            }         ]      },      {         \"elements\" : [            {               \"distance\" : {                  \"text\" : \"0,2 km\",                  \"value\" : 170               },               \"duration\" : {                  \"text\" : \"1 min\",                  \"value\" : 37               },               \"status\" : \"OK\"            },            {               \"distance\" : {                  \"text\" : \"53 m\",                  \"value\" : 53               },               \"duration\" : {                  \"text\" : \"1 min\",                  \"value\" : 14               },               \"status\" : \"OK\"            },            {               \"distance\" : {                  \"text\" : \"0,4 km\",                  \"value\" : 431               },               \"duration\" : {                  \"text\" : \"2 minutos\",                  \"value\" : 93               },               \"status\" : \"OK\"            },            {               \"distance\" : {                  \"text\" : \"0,2 km\",                  \"value\" : 246               },               \"duration\" : {                  \"text\" : \"1 min\",                  \"value\" : 54               },               \"status\" : \"OK\"            },            {               \"distance\" : {                  \"text\" : \"0,4 km\",                  \"value\" : 372               },               \"duration\" : {                  \"text\" : \"1 min\",                  \"value\" : 84               },               \"status\" : \"OK\"            },            {               \"distance\" : {                  \"text\" : \"0,3 km\",                  \"value\" : 288               },               \"duration\" : {                  \"text\" : \"1 min\",                  \"value\" : 66               },               \"status\" : \"OK\"            },            {               \"distance\" : {                  \"text\" : \"1 m\",                  \"value\" : 0               },               \"duration\" : {                  \"text\" : \"1 min\",                  \"value\" : 0               },               \"status\" : \"OK\"            },            {               \"distance\" : {                  \"text\" : \"0,6 km\",                  \"value\" : 602               },               \"duration\" : {                  \"text\" : \"2 minutos\",                  \"value\" : 130               },               \"status\" : \"OK\"            },            {               \"distance\" : {                  \"text\" : \"0,5 km\",                  \"value\" : 520               },               \"duration\" : {                  \"text\" : \"2 minutos\",                  \"value\" : 112               },               \"status\" : \"OK\"            },            {               \"distance\" : {                  \"text\" : \"0,1 km\",                  \"value\" : 124               },               \"duration\" : {                  \"text\" : \"1 min\",                  \"value\" : 31               },               \"status\" : \"OK\"            }         ]      },      {         \"elements\" : [            {               \"distance\" : {                  \"text\" : \"0,8 km\",                  \"value\" : 837               },               \"duration\" : {                  \"text\" : \"3 minutos\",                  \"value\" : 174               },               \"status\" : \"OK\"            },            {               \"distance\" : {                  \"text\" : \"0,7 km\",                  \"value\" : 720               },               \"duration\" : {                  \"text\" : \"3 minutos\",                  \"value\" : 150               },               \"status\" : \"OK\"            },            {               \"distance\" : {                  \"text\" : \"0,6 km\",                  \"value\" : 632               },               \"duration\" : {                  \"text\" : \"2 minutos\",                  \"value\" : 131               },               \"status\" : \"OK\"            },            {               \"distance\" : {                  \"text\" : \"0,9 km\",                  \"value\" : 913               },               \"duration\" : {                  \"text\" : \"3 minutos\",                  \"value\" : 190               },               \"status\" : \"OK\"            },            {               \"distance\" : {                  \"text\" : \"0,6 km\",                  \"value\" : 573               },               \"duration\" : {                  \"text\" : \"2 minutos\",                  \"value\" : 123               },               \"status\" : \"OK\"            },            {               \"distance\" : {                  \"text\" : \"0,6 km\",                  \"value\" : 629               },               \"duration\" : {                  \"text\" : \"2 minutos\",                  \"value\" : 132               },               \"status\" : \"OK\"            },            {               \"distance\" : {                  \"text\" : \"0,9 km\",                  \"value\" : 934               },               \"duration\" : {                  \"text\" : \"3 minutos\",                  \"value\" : 189               },               \"status\" : \"OK\"            },            {               \"distance\" : {                  \"text\" : \"1 m\",                  \"value\" : 0               },               \"duration\" : {                  \"text\" : \"1 min\",                  \"value\" : 0               },               \"status\" : \"OK\"            },            {               \"distance\" : {                  \"text\" : \"0,7 km\",                  \"value\" : 720               },               \"duration\" : {                  \"text\" : \"3 minutos\",                  \"value\" : 150               },               \"status\" : \"OK\"            },            {               \"distance\" : {                  \"text\" : \"0,8 km\",                  \"value\" : 792               },               \"duration\" : {                  \"text\" : \"3 minutos\",                  \"value\" : 167               },               \"status\" : \"OK\"            }         ]      },      {         \"elements\" : [            {               \"distance\" : {                  \"text\" : \"0,8 km\",                  \"value\" : 800               },               \"duration\" : {                  \"text\" : \"3 minutos\",                  \"value\" : 163               },               \"status\" : \"OK\"            },            {               \"distance\" : {                  \"text\" : \"0,7 km\",                  \"value\" : 683               },               \"duration\" : {                  \"text\" : \"2 minutos\",                  \"value\" : 139               },               \"status\" : \"OK\"            },            {               \"distance\" : {                  \"text\" : \"0,6 km\",                  \"value\" : 594               },               \"duration\" : {                  \"text\" : \"2 minutos\",                  \"value\" : 121               },               \"status\" : \"OK\"            },            {               \"distance\" : {                  \"text\" : \"0,9 km\",                  \"value\" : 876               },               \"duration\" : {                  \"text\" : \"3 minutos\",                  \"value\" : 180               },               \"status\" : \"OK\"            },            {               \"distance\" : {                  \"text\" : \"0,5 km\",                  \"value\" : 535               },               \"duration\" : {                  \"text\" : \"2 minutos\",                  \"value\" : 112               },               \"status\" : \"OK\"            },            {               \"distance\" : {                  \"text\" : \"0,6 km\",                  \"value\" : 591               },               \"duration\" : {                  \"text\" : \"2 minutos\",                  \"value\" : 121               },               \"status\" : \"OK\"            },            {               \"distance\" : {                  \"text\" : \"0,9 km\",                  \"value\" : 896               },               \"duration\" : {                  \"text\" : \"3 minutos\",                  \"value\" : 177               },               \"status\" : \"OK\"            },            {               \"distance\" : {                  \"text\" : \"82 m\",                  \"value\" : 82               },               \"duration\" : {                  \"text\" : \"1 min\",                  \"value\" : 18               },               \"status\" : \"OK\"            },            {               \"distance\" : {                  \"text\" : \"1 m\",                  \"value\" : 0               },               \"duration\" : {                  \"text\" : \"1 min\",                  \"value\" : 0               },               \"status\" : \"OK\"            },            {               \"distance\" : {                  \"text\" : \"0,8 km\",                  \"value\" : 754               },               \"duration\" : {                  \"text\" : \"3 minutos\",                  \"value\" : 157               },               \"status\" : \"OK\"            }         ]      },      {         \"elements\" : [            {               \"distance\" : {                  \"text\" : \"46 m\",                  \"value\" : 46               },               \"duration\" : {                  \"text\" : \"1 min\",                  \"value\" : 7               },               \"status\" : \"OK\"            },            {               \"distance\" : {                  \"text\" : \"0,3 km\",                  \"value\" : 313               },               \"duration\" : {                  \"text\" : \"1 min\",                  \"value\" : 66               },               \"status\" : \"OK\"            },            {               \"distance\" : {                  \"text\" : \"0,3 km\",                  \"value\" : 307               },               \"duration\" : {                  \"text\" : \"1 min\",                  \"value\" : 62               },               \"status\" : \"OK\"            },            {               \"distance\" : {                  \"text\" : \"0,1 km\",                  \"value\" : 121               },               \"duration\" : {                  \"text\" : \"1 min\",                  \"value\" : 23               },               \"status\" : \"OK\"            },            {               \"distance\" : {                  \"text\" : \"0,2 km\",                  \"value\" : 247               },               \"duration\" : {                  \"text\" : \"1 min\",                  \"value\" : 54               },               \"status\" : \"OK\"            },            {               \"distance\" : {                  \"text\" : \"0,2 km\",                  \"value\" : 163               },               \"duration\" : {                  \"text\" : \"1 min\",                  \"value\" : 35               },               \"status\" : \"OK\"            },            {               \"distance\" : {                  \"text\" : \"0,5 km\",                  \"value\" : 533               },               \"duration\" : {                  \"text\" : \"2 minutos\",                  \"value\" : 105               },               \"status\" : \"OK\"            },            {               \"distance\" : {                  \"text\" : \"0,5 km\",                  \"value\" : 478               },               \"duration\" : {                  \"text\" : \"2 minutos\",                  \"value\" : 99               },               \"status\" : \"OK\"            },            {               \"distance\" : {                  \"text\" : \"0,4 km\",                  \"value\" : 395               },               \"duration\" : {                  \"text\" : \"1 min\",                  \"value\" : 81               },               \"status\" : \"OK\"            },            {               \"distance\" : {                  \"text\" : \"1 m\",                  \"value\" : 0               },               \"duration\" : {                  \"text\" : \"1 min\",                  \"value\" : 0               },               \"status\" : \"OK\"            }         ]      }   ],   \"status\" : \"OK\"}";
}
