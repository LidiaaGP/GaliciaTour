package com.example.navigationdrawer;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class TurismoGaliciaDB extends SQLiteOpenHelper {
    private static final String DB_NAME = "TurismoGaliciaDB.db";
    private static final int DB_VERSION = 2;

    private SQLiteDatabase db;

    public TurismoGaliciaDB(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }
    ContentValues values = new ContentValues();
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE localidades (id_localidad INTEGER PRIMARY KEY AUTOINCREMENT," +
                " localidad TEXT" +
                ")");
        String SQLInsertloc1="INSERT INTO localidades(localidad) VALUES('Santiago de Compostela')";
        String SQLInsertloc2="INSERT INTO localidades(localidad) VALUES('Vigo')";
        String SQLInsertloc3="INSERT INTO localidades(localidad) VALUES('Lugo')";
        String SQLInsertloc4="INSERT INTO localidades(localidad) VALUES('Pontevedra')";
        String SQLInsertloc5="INSERT INTO localidades(localidad) VALUES('A Coruña')";

        db.execSQL(SQLInsertloc1);
        db.execSQL(SQLInsertloc2);
        db.execSQL(SQLInsertloc3);
        db.execSQL(SQLInsertloc4);
        db.execSQL(SQLInsertloc5);

        db.execSQL("CREATE TABLE lugares_interes " +
                "(id_lugar INTEGER PRIMARY KEY AUTOINCREMENT" +
                ",nombre TEXT," +
                "descripcion TEXT," +
                "id_localidad INTEGER," +
                "latitud REAL,"+
                "longitud REAL,"+
                "FOREIGN KEY (id_localidad) REFERENCES localidades(id_localidad)" +
                ")");

        db.execSQL("CREATE TABLE donde_comer " +
                "(id_lugar INTEGER PRIMARY KEY AUTOINCREMENT" +
                ",nombre_restaurante TEXT," +
                "descripcion_restaurante TEXT," +
                "id_localidad INTEGER," +
                "latitud REAL,"+
                "longitud REAL,"+
                "FOREIGN KEY (id_localidad) REFERENCES localidades(id_localidad)" +
                ")");


        db.execSQL("CREATE TABLE rutas (" +
                "id_lugar INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nombre_ruta TEXT, " +
                "descripcion_ruta TEXT, " +
                "dificultad TEXT, " +
                "tiempo_transcurrido TEXT, " +
                "distancia TEXT, " +
                "id_localidad INTEGER, " +
                "FOREIGN KEY (id_localidad) REFERENCES localidades(id_localidad)" +
                ")");




        //Turismo Santiago
        String SQLInsert_San1="INSERT INTO lugares_interes(nombre,descripcion,id_localidad,latitud,longitud) VALUES('Catedral de Santiago de Compostela','Es el corazón de Santiago de Compostela y por lo tanto el corazón de Galicia. Uno de los grandes atractivos para visitantes y turistas de todo el mundo, una motivación espiritual para muchos y arquitectónica o histórica para otros. Hablamos de la Catedral de Santiago de Compostela: un templo construido a lo largo de varios siglos, con una belleza pasmosa y que combina románico, gótico y barroco con un estilo digno de ver.\n" +
                "\n" +
                "Estamos ante una catedral que hay que ver por todos sus costados, desde todas las plazas que la rodean y, por supuesto, desde su interior. Adéntrate, si puedes con un/a guía que te explique todo bien, visita los tesoros escondidos de la catedral y no te pierdas la historia del Apóstol Santiago.\n" +
                "La Catedral, situada en pleno centro histórico de Santiago de Compostela, donde supuestamente fue enterrado el Apóstol Santiago el Mayor, esta catedral es la meta final de los peregrinos que realicen cualquiera de los Caminos de Santiago. Si esto no te parece reclamo suficiente, estamos también ante la piedra inaugural de la construcción de la ciudad de Santiago de Compostela.',1,42.88059620000001, -8.5446412)";
        db.execSQL(SQLInsert_San1);


        String SQLInsert_San2="INSERT INTO lugares_interes(nombre,descripcion,id_localidad,latitud,longitud) VALUES('Museo Catedralicio de Santiago de Compostela','Situado dentro de la catedral, es el museo histórico, artístico y arqueológico de la basílica de Santiago Apóstol. Además de las diferentes salas, que exhiben numerosas piezas procedentes de las excavaciones realizadas en la catedral, también se puede visitar el claustro, la sala capitular, la biblioteca, el tesoro, la capilla de las reliquias, la colección de tapices y la cripta del Pórtico de la Gloria y el palacio de Gelmírez. Este museo cuenta con un nuevo atractivo: el recientemente reconstruido coro pétreo, obra del Maestro Mateo.',1,42.8802387900078,-8.54517327577852)";
        db.execSQL(SQLInsert_San2);

        String SQLInsert_San3="INSERT INTO lugares_interes(nombre,descripcion,id_localidad,latitud,longitud) VALUES('Mercado de Abastos en Santiago de Compostela','Rodeado de un entorno histórico y arquitectónico insuperable, se encuentra el Mercado de Abastos de Santiago de Compostela. Tras la Catedral, es el segundo lugar de la ciudad más visitado por los turistas y cuando uno entra al edificio, construido en 1873, de la Rúa Ameás, entiende la razón.\n" +
                "\n" +
                "Las filas de puestos de productos de todo tipo confieren un variado colorido al lugar. Aquí podemos encontrar frutas y verduras, carnes, pescados, telas, perfumes, flores, quesos, pan y muchas cosas más. Pasea, huele, mira, prueba y… ¡Cocina!. El Mercado de Abastos te da la posibilidad de incluir clases de cocina en tu lista de cosas que hacer en Santiago de Compostela.',1,42.87994639643054, -8.541304548506957)";
        db.execSQL(SQLInsert_San3);

        String SQLInsert_San4="INSERT INTO lugares_interes(nombre,descripcion,id_localidad,latitud,longitud) VALUES('Universidad de Santiago de Compostela (USC)','Con más de 500 años de historia, la Universidad de Santiago de Compostela es de las más antiguas del mundo.\n" +
                "\n" +
                "La institución ofrece visitas guiadas para dar a conocer su gran patrimonio histórico. Un guía licenciado en la USC te mostrará al primer gran mecenas de la Universidad, Don Alonso III de Fonseca, un hombre del Renacimiento que sería nombrado arzobispo en 1507. Podrás admirar la bella arquitectura de los antiguos edificios arrebatados a los jesuitas tras su expulsión, la gran colección única de la llamada Biblioteca América (incluyendo un libro de Fernando I de León, del año 1055), el paraninfo, la antigua Iglesia jesuita y otras maravillas más. Acaba contemplando el perfil de la Ciudad Vieja desde la posición elevada en la que se encuentra la Universidad.',1,42.87940494206543, -8.545424008996873)";
        db.execSQL(SQLInsert_San4);

        String SQLInsert_San5="INSERT INTO lugares_interes(nombre,descripcion,id_localidad,latitud,longitud) VALUES('Monte do Gozo','El Monte del Gozo o Monte do Gozo es una colina de 380 m de altura situada a tan solo 5 kms de Santiago de Compostela. Lejos de ser un lugar más, este punto en concreto es conocido en el mundo entero por ser el punto donde por primera vez los peregrinos llegados a la ciudad santa, pueden ver las torres de la catedral a lo lejos. El nombre de Monte do Gozo nace precisamente del sentimiento de desbordante felicidad que sentían los peregrinos en ese momento." +
                    "Si vais a Santiago en peregrinación entenderéis de primera mano su significado. Si estáis en Santiago de Compostela pasando unos días, vale la pena entender y conocer un poco más de este lugar.',1,42.885563310475206, -8.500545428480157)";
        db.execSQL(SQLInsert_San5);

        String SQLInsert_San6="INSERT INTO lugares_interes(nombre,descripcion,id_localidad,latitud,longitud) VALUES('Parque de la Alameda','Aunque el parque recibe el nombre genérico de Alameda, se compone de tres partes bien diferenciadas: el paseo de la Alameda, la carballeira (\"robledal\") de Santa Susana y el paseo de la Herradura. La unidad así formada es, desde el siglo XIX, el más importante punto de referencia de los paseos y del ocio de los santiagueses, caracterizada por ser un espacio muy acogedor, una especie de salón natural.\n" +
                " \n" +
                "Su ubicación privilegiada, bordeando una parte de la ciudad histórica, y con una magnífica perspectiva sobre su fachada oeste -la más monumental-, lo convirtió en el principal jardín urbano, destacado además por la variedad y porte de sus especies arbóreas y ornamentales, como el conjunto de robles, los espléndidos eucaliptos o la pérgola con vistas que componen los castaños de Indias en el paseo de la Herradura.',1,42.876944400076, -8.547607546240425)";
        db.execSQL(SQLInsert_San6);


        String SQLInsert_San7="INSERT INTO lugares_interes(nombre,descripcion,id_localidad,latitud,longitud) VALUES('Parque de Belvís','El parque se extiende a lo largo de la vaguada de Belvís: un espacio alargado constituido por prados por los que corre un pequeño arroyo. Los muros, las bancadas del terreno y las vías históricas -como el pintoresco callejón de las Trompas- se respetaron en el proyecto de este parque.\n" +
                "\n" +
                "Este vacío verde separa, y a la vez relaciona, el recinto histórico con las grandes edificaciones del convento de Belvís y del Seminario Menor, constituyendo una especie de foso natural de la ciudad medieval. Desde su parte más alta se disfrutan vistas singulares de toda la ciudad.\n',1,42.87728656992427, -8.538305265973658)";
        db.execSQL(SQLInsert_San7);


        String SQLInsert_San8="INSERT INTO lugares_interes(nombre,descripcion,id_localidad,latitud,longitud) VALUES('Seminario Mayor','El Seminario Mayor constituye una comunidad humana, eclesial, diocesana y educativa, a la que el Obispo, según las normas de la Iglesia, confía la tarea de formar a los futuros sacerdotes seculares diocesanos.',1,42.881370302162416, -8.544696603165823)";
        db.execSQL(SQLInsert_San8);


        String SQLInsert_San9="INSERT INTO lugares_interes(nombre,descripcion,id_localidad,latitud,longitud) VALUES('Seminario Menor','El Seminario Menor de Santiago de Compostela surge en la década de los 50 del pasado siglo. Dedicado a Nuestra Señora de la Asunción, es la obra soñada del Cardenal Quiroga Palacios para acoger a los cientos de seminaristas que ya no cabían en los muros de San Martín Pinario.\n" +
                "Es uno de los sitios de la ciudad que, nuevamente, está relacionado con una de las realidades más viva y más importante de la ciudad: la de sus estudiantes.\n" +
                "Ubicado en Belvís, en el histórico barrio de San Pedro. La etimología popular sugiere que Belvís es una apócope de Bela Vista, y no le falta razón: el Seminario Menor tiene unas magníficas  vistas  de  la zona monumental compostelana.',1,42.87670853890432, -8.536599920831852)";
        db.execSQL(SQLInsert_San9);


        //Turismo Vigo

        String SQLInsertVi1="INSERT INTO lugares_interes(nombre,descripcion,id_localidad,latitud,longitud) VALUES('Castillo de San Sebastián en Vigo','La fortaleza de San Sebastián, situado en la parte trasera del actual Ayuntamiento de Vigo se levantó, al igual que el resto de las defensas de la ciudad, con motivo de la Guerra de Restauración Portuguesa .\n" +
                "\n" +
                "Fue construido en el siglo XVII como defensa para la ciudad de Vigo ante los piratas ingleses, aliados de los portugueses en la Guerra de la Restauración de Portugal.\n" +
                "\n" +
                "En el lugar en donde se levanta el castillo había una ermita dedicada a San Sebastián, y la nueva muralla cerraría hasta dicha capilla, donde además se levantaría un fuerte. Desde el castillo el muro iba hasta la Puerta del Sol, bajando por la calle Carral hasta el muelle de A Laxe, siguiendo por Beiramar hasta el Berbés y subiendo de nuevo por la calle Real hasta la ermita.\n" +
                "\n" +
                "Juan de Villaroel y Prado fue quien proyectó los trabajos tanto del castillo de San Sebastián como de la Fortaleza de O Castro, situada a unos cientos de metros monte arriba.',2,42.236838678178465, -8.726632370025563)";
        db.execSQL(SQLInsertVi1);

        String SQLInsertVi2="INSERT INTO lugares_interes(nombre,descripcion,id_localidad,latitud,longitud) VALUES('Sireno de Vigo y la Puerta del Sol','El Sireno es el monumento de Vigo por excelencia. Erguido en la Porta do Sol, esta obra del escultor gallego Francisco Leiro es uno de los símbolos del Vigo moderno, impresionante por su factura y por el elevadísimo pedestal sobre el que se sitúa la estatua. La escultura, instalada en 1991, representa a un personaje imaginario, un híbrido de pez y hombre, y se ha convertido en uno de los monumentos más representativos de Vigo gracias a su rabiosa modernidad, como un espejo de Vigo, a la que vigila desde su altura.',2,42.23782606868535, -8.724901888492886)";
        db.execSQL(SQLInsertVi2);

        String SQLInsertVi3="INSERT INTO lugares_interes(nombre,descripcion,id_localidad,latitud,longitud) VALUES('Concatedral de Santa María de Vigo','En pleno Casco Viejo, justo al lado del Mercado de A Pedra, está la Concatedral de Santa María de Vigo, un templo de principios del siglo XIX de estilo neoclásico, pero con torres barrocas. Pese a que esta construcción no tenga tantos siglos de antigüedad, existen registros confirmando la existencia de una iglesia dedicada a Santa María que se situaba justo en el lugar en donde hoy encontramos la Concatedral. Estos registros datan del siglo XII.',2,42.2393118091978, -8.726182829691792)";
        db.execSQL(SQLInsertVi3);

        String SQLInsertVi4="INSERT INTO lugares_interes(nombre,descripcion,id_localidad,latitud,longitud) VALUES('El Puerto de Vigo','Aqui encontramos la base de multinacionales como Pescanova, y de otras compañías pesqueras presentes en países a nivel global como Argentina, Namibia, o Sudáfrica. El año pasado, este puerto tuvo un movimiento de marisco y pescado que rondó las 870.000 toneladas. Un punto clave que ver en Vigo, sn lugar a duda, pues no deja de ser el corazón de esta ciudad portuaria.',2,42.23159782073613, -8.742376999827055)";
        db.execSQL(SQLInsertVi4);

        String SQLInsertVi5="INSERT INTO lugares_interes(nombre,descripcion,id_localidad,latitud,longitud) VALUES('Islas Cíes','Paraíso natural en la ría de Vigo, las Islas forman parte del Parque Natural marítimo-terrestre de las Islas Atlánticas de Galicia. Este archipiélago lo forman tres islas: Norte o Monteagudo, Del Medio o do Faro y Sur o San Martiño. Las dos primeras están unidas por medio del arenal de la Playa de Rodas y una escollera. Las Islas Cíes fueron declaradas Parque Natural en 1980 e incluidas en el Parque Nacional M-T de las Islas Atlánticas de Galicia creado en el año 2002, junto a la Isla de Ons, la isla de Sálvora y la de Cortegada.\n" +
                "Las Islas Cíes prometen al visitante una excelente excursión en un espacio natural altamente protegido para disfrutar al máximo de la naturaleza. En este paraíso virgen podemos destacar la Playa de Rodas, galardonada con el título de “La Mejor Playa del Mundo” por el reconocido diario Británico “The Guardian”. Vale la pena venir y recorrer las islas, visitar las playas y disfrutar de la naturaleza en uno de los pocos Paraísos Vírgenes que nos quedan en la tierra.',2,42.214554363679035, -8.905220655677322)";
        db.execSQL(SQLInsertVi5);

        String SQLInsertVi6="INSERT INTO lugares_interes(nombre,descripcion,id_localidad,latitud,longitud) VALUES('VigoZoo','El zoo de Vigo, Vigozoo, es el único parque zoológico que existe en Galicia, un lugar ideal para pasar la tarde en familia, aprendiendo más acerca de la naturaleza, nuestro ecosistema y la vida de diferentes especies de animales.\n" +
                "Su recinto en A Madroa, en el barrio de Teis, está a unos 10 km del centro, y ocupa más de 55.000 m² de superficie.\n" +
                "Entre los animales que podrás ver en este zoo hay mamíferos de África, Asia y América, como leones, tigres y osos pardos, o especies propias de la Península como el lince europeo. Disfrutaréis con los hiperactivos monos y os quedaréis hipnotizados por la grandeza del lobo.\n" +
                "En el Exotarium viven más de 50 especies de insectos, arácnidos, anfibios y reptiles, y en Nocturama las especies de hábitos nocturnos.',2,42.2485737460864, -8.674961128471736)";
        db.execSQL(SQLInsertVi6);

        String SQLInsertVi7="INSERT INTO lugares_interes(nombre,descripcion,id_localidad,latitud,longitud) VALUES('Playa de Samil','Es la playa más famosa de Vigo y todo un emblema para la ciudad. Es una playa extensa, muy familiar, de aguas transparentes y arena fina. Cuenta con todos los servicios, restaurantes, bares y multitud de hoteles.',2,42.208984619653705, -8.776518671778065)";
        db.execSQL(SQLInsertVi7);

        String SQLInsertVi8="INSERT INTO lugares_interes(nombre,descripcion,id_localidad,latitud,longitud) VALUES('Playa de O Vao','Es otra de las mejores playas de toda Galicia. Casi un kilómetro de arena fina y aguas templadas, con una posición muy resguardada del viento y unida por un puente con la cercana isla de Toralla.',2,42.19829668316442, -8.79186837595486)";
        db.execSQL(SQLInsertVi8);

        String SQLInsertVi9="INSERT INTO lugares_interes(nombre,descripcion,id_localidad,latitud,longitud) VALUES('Playa de Tombo do Gato','Es una playa de arena fina con forma de media luna, al lado del paseo del sendero azul.\n" +
                "En los extremos, se alterna arena con rocas, que también se encuentran en el fondo sumergido. Con marea baja duplica su superficie. En la parte posterior presenta una zona ajardinada.',2,42.220225048014136, -8.77606468636274)";
        db.execSQL(SQLInsertVi9);


        //Turismo Lugo
        String SQLInsertLu="INSERT INTO lugares_interes(nombre,descripcion,id_localidad,latitud,longitud) VALUES('Muralla Romana de Lugo','La muralla romana de Lugo rodea el casco histórico de la ciudad gallega de Lugo en la provincia del mismo nombre en España. La antigua ciudad romana de Lucus Augusti, fundada por Paulo Fabio Máximo en nombre del emperador Augusto en el año 13 a. C. con la finalidad de anexionar, definitivamente, el noroeste de la península ibérica al Imperio romano fue dotada en el Bajo Imperio de un muro de defensa que ha perdurado, con escasas reformas, hasta la actualidad.\n" +
                "\n" +
                "Construida como separación y defensa se ha transformado en un elemento integrador entre la antigua Lucus y la que se ha desarrollado a su alrededor. Sus diez puertas realizan la función de unir una parte de la ciudad con la otra y su paseo de ronda, adarve, se ha tornado en una calle más que es recorrida por los viandantes autóctonos y visitantes.',3,43.008834833373, -7.559199150042972)";
        db.execSQL(SQLInsertLu);

        String SQLInsertLu2="INSERT INTO lugares_interes(nombre,descripcion,id_localidad,latitud,longitud) VALUES('Catedral de Lugo','Construida entre 1129 y 1273, sobre una iglesia de principios del siglo I, este templo católico en el que predomina el estilo románico, tiene varios tesoros como el pórtico de la parte norte, el retablo mayor, el Coro, la Capilla de San Froilán y la Capilla de la Virgen de los Ojos Grandes, una de las patronas de Lugo.',3,43.00939340967838, -7.5576949861987295)";
        db.execSQL(SQLInsertLu2);
        String SQLInsertLu3="INSERT INTO lugares_interes(nombre,descripcion,id_localidad,latitud,longitud) VALUES('Plaza de Santa María','En la parte trasera de la Catedral se encuentra la Praza de Santa María, una de las más bonitas que ver en Lugo. En esta pintoresca plaza anclada en el tiempo encontramos los restos de una piscina romana, del siglo IV d.C., visible a través de una cristalera.\n" +
                "\n" +
                "Igualmente, gobernándola, tenemos el Pazo Episcopal, de varias etapas constructivas. Sobre la fachada se encuentra el escudo del obispo Cayetano Gil Taboada. Sólo queda sentarse en las escaleras frente al Palacio y disfrutar de la majestuosa Catedral.',3,43.009577862797265, -7.557978622903867)";
        db.execSQL(SQLInsertLu3);

        String SQLInsertLu4="INSERT INTO lugares_interes(nombre,descripcion,id_localidad,latitud,longitud) VALUES('Plaza Mayor de Lugo','La Plaza Mayor, también conocida como Plaza de España, era el lugar en el que se celebraba un mercado en la época medieval y ahora es el corazón del centro histórico de Lugo.\n" +
                "Rodeada de soportales donde se concentran cafeterías y restaurantes con amplias terrazas donde tomar algo, esta amplia plaza está presidida por el imponente edificio del Ayuntamiento (Pazo do Concello), una de las obras barrocas más importantes de Galicia, y el Convento de los Franciscanos, en el lado izquierdo.\n" +
                "En el centro de la plaza se encuentran unos bonitos jardines y un quiosco de música.',3,43.009617124058686, -7.556879081728112)";
        db.execSQL(SQLInsertLu4);

        String SQLInsertLu5="INSERT INTO lugares_interes(nombre,descripcion,id_localidad,latitud,longitud) VALUES('Bosque da Fervenza en Lugo','El río Miño nace en la provincia y ha formado de manera significante sus paisajes . En el curso alto de dicho ríos podrás visitar uno de los bosques más bonitos de Galicia, el Bosque da Fervenza. Es uno de los bosques de inundación más significantes que queda en España y su nombre «fervenza» se debe a que sus aguas parecen estar hirviendo en los rápidos del río. Es un bosque realmente mágico que está lleno de senderos muy fáciles para que conozcas uno de los parajes naturales imprescindibles de la provincia." +
                "En el centro de la plaza se encuentran unos bonitos jardines y un quiosco de música.',3,42.88454866735492, -7.527679837419753)";
        db.execSQL(SQLInsertLu5);

        String SQLInsertLu6="INSERT INTO lugares_interes(nombre,descripcion,id_localidad,latitud,longitud) VALUES('Playa de las Catedrales','La Playa de las Catedrales es un monumento natural que se ubica en la formación geomorfológica denominada como la Rasa Cantábrica, en la provincia de Lugo y que abarca desde la localidad de Burela en su extremo occidental, hasta San Vicente de la Barquera en el oriental. La Rasa Cantábrica se trata de una superficie plana situada entre el mar Cantábrico y las estribaciones montañosas, generando de esta manera un tipo de costas lineal en donde destaca la formación de playas a pié de acantilado y arenales separados a menudo por farallones. También es conocida como As Catedrais\n" +
                "\n" +
                "Hay que tener en cuenta la tabla de mareas de la playa de las Catedrales, ya que solo podremos sacar provecho de nuestra visita a la Playa De Las Catedrales si esta la realizamos coincidiendo el periodo de tiempo en el que el nivel del mar desciende, lo que nos permitirá recorrer los estrechos pasillos entre los acantilados, grietas, cuevas y pasar bajo sus enormes arcos. Este periodo de tiempo está condicionado por el fenómeno físico de las mareas, por lo cual es imprescindible que conozcamos la predicción de la bajamar correspondiente a la fecha de nuestra visita para bajar al arenal.',3,43.55405794906853, -7.1572276777182156)";
        db.execSQL(SQLInsertLu6);

        String SQLInsertLu7="INSERT INTO lugares_interes(nombre,descripcion,id_localidad,latitud,longitud) VALUES('Casa dos Mosaicos','En la Rúa Doutor Castro podemos encontrar los restos de una domus romana del s. III, o lo que es lo mismo, una casa romana de cierto nivel económico. Los mosaicos del suelo son una maravilla y representan motivos geométricos.\n" +
                "\n" +
                "Además de apreciarse desde la propia calle a través de cristales, se puede entrar a un pequeño museo donde se aprecia con mayor claridad, además de otros restos de la vivienda. El lugar cuenta también con explicaciones y proyección audiovisual.',3,43.01054709834349, -7.557098826060633)";
        db.execSQL(SQLInsertLu7);

        String SQLInsertLu8="INSERT INTO lugares_interes(nombre,descripcion,id_localidad,latitud,longitud) VALUES('Museo Universitario «A Domus do Mitreo»','Situado frente a la fachada principal de la Catedral, se exponen restos romanos descubiertos al demolerse el Pazo de Montenegro, en 1998.\n" +
                "\n" +
                "El museo cuenta con dos pisos. El piso subterráneo es dedicado a los restos de una Domus, a la propia Muralla y a un Mitreo, siendo este último un templo dedicado al Dios Mitra. El piso superior acoge una exposición sobre el hallazgo y elementos explicativos desde la época romana hasta el siglo XX.',3,43.00915153883344,-7.5591586726955144)";
        db.execSQL(SQLInsertLu8);

        String SQLInsertLu9="INSERT INTO lugares_interes(nombre,descripcion,id_localidad,latitud,longitud) VALUES('Cañón y riberas del Sil','El Cañón del Sil es, sin duda, uno de los elementos más importantes de Ribeira Sacra. Esta profunda garganta de roca, agua y sinuosas curvas no deja indiferente a quien la contempla. Sus verticales pendientes trabajadas desde antiguo, siguen siendo hoy en día el sustento de muchos habitantes de la zona, que sobre ellas producen una uva de excelente calidad. Este paraje es también refugio de múltiples especies animales y vegetales, que encuentran entre estas paredes y en sus aguas las condiciones que precisan para su existencia.\n" +
                "\n" +
                "Entre las provincias de Lugo y Ourense, a poco más de doscientos metros de altura, se encuentra el tramo final del río Sil. A sus laterales, y a lo largo de más de treinta y cinco kilómetros se levantan dos paredes que en algunas zonas se elevan hasta casi quinientos metros en vertical sobre sus aguas. Estas laderas guían al río a través de amplias curvas y meandros, que forman algunos de los rincones más mágicos de toda Galicia.',3,42.411036490601234, -7.632368889799922)";
        db.execSQL(SQLInsertLu9);


        //Turismo Pontevedra
        String SQLInsertPon1="INSERT INTO lugares_interes(nombre,descripcion,id_localidad,latitud,longitud) VALUES('Santuario de la Virgen Peregrina','Lo primero que nos encontramos al llegar al casco antiguo fue el bonito Santuario de la Virgen Peregrina, uno de los lugares imprescindibles que ver en Pontevedra, de piedra y paredes encaladas en blanco. Su planta tiene forma de concha de vieira que es el símbolo del camino De Santiago." +
                "Y es que la iglesia está en una de las plazas de Pontevedra por las que pasa el camino De Santiago portugués.',4,42.43078761366287, -8.643619555740408)";
        db.execSQL(SQLInsertPon1);

        String SQLInsertPon2="INSERT INTO lugares_interes(nombre,descripcion,id_localidad,latitud,longitud) VALUES('Plaza de la Herrería','Unida a la Plaza Peregrina y a la Plaza Estrella encontramos la Plaza de la Herrería o Plaza da Ferraría. Allí estaban ubicados en la antigüedad los talleres de hierro forjado." +
                "Uno de los edificios que más destaca de la Plaza es el Convento de San Francisco, construido en el siglo XIV. En su interior destacan el crucero, la imagen del nazareno y varias pinturas murales de los siglos XVI y XVIII.',4,42.431472724475626, -8.644219663589201)";
        db.execSQL(SQLInsertPon2);

        String SQLInsertPon3="INSERT INTO lugares_interes(nombre,descripcion,id_localidad,latitud,longitud) VALUES('Basílica de Santa María la Mayor','Ubicada en el casco histórico de Pontevedra, en la Avenida de Santa María 24, es uno de los mejores ejemplos del gótico gallego, habiendo sido declarado BIC (Bien de Interés Cultural) en el año 1931. También cuenta con la distinción de \"Real Santuario\" y está considerado el principal monumento de la provincia de Pontevedra. Pontevedra no es sede episcopal, sino que pertenece a la diócesis de Santiago. Es por ello por lo que no tiene catedral. Posiblemente por esta razón, la basílica de Santa María es considerada la iglesia principal de Pontevedra.\n" +
                "\n" +
                "Se sitúa sobre un promontorio que domina el paso del río Lérez, núcleo originario de la ciudad de Pontevedra. Santa María fue declarada basílica en 1962 por decreto del Papa Juan XXIII. Esta basílica es uno de los ejemplos más destacados del gótico isabelino de Galicia, habiendo sido calificada por el historiador gallego Antonio López Ferreiro como \"la perla del arte gallego\".',4,42.43379858787328, -8.647464966493494)";
        db.execSQL(SQLInsertPon3);

        String SQLInsertPon4="INSERT INTO lugares_interes(nombre,descripcion,id_localidad,latitud,longitud) VALUES('Ruinas de Santo Domingo','Las Ruinas de Santo Domingo, situadas en la ciudad de Pontevedra, son los restos que se conservan de un antiguo convento gótico construido por los dominicos en el siglo XIII. Forma parte del Museo Provincial de Pontevedra junto a otros 5 edificios, entre los que están el edificio de Castro Monteagudo y el edificio Fernández López, y fue declarada junto a ellos, Bien de Interés Cultural en el año 1895. En la actualidad se conservan de esta antigua edificación la cabecera porticada de la iglesia con cinco ábsides poligonales y un muro lateral en el que se observa un rosetón. Además de estos restos, también se conservan piezas con más valor arqueológico, sin embargo, estos restos se guardan en el Museo de Pontevedra para evitar su deterioro al aire libre.',4,42.43134758666411, -8.64704664327675)";
        db.execSQL(SQLInsertPon4);

        String SQLInsertPon5="INSERT INTO lugares_interes(nombre,descripcion,id_localidad,latitud,longitud) VALUES('Playa de Castiñeiras','La playa de Castiñeiras en O Hío, Cangas, forma parte de una serie de calas que se separan por pequeños cabos y formaciones rocosas. Forman parte de este conjunto comprendido entre Punta Ameixide y Punta Pinea, la playa de San Xián y la playa de Pipín. La de Castiñeiras ocupa una longitud de 250 metros y se localiza en un entorno de extremada belleza, con aguas claras y limpias. Se caracteriza por la presencia de un conjunto rocoso en el medio del arenal.',4,42.288187782967114, -8.838572997707537)";
        db.execSQL(SQLInsertPon5);

        String SQLInsertPon6="INSERT INTO lugares_interes(nombre,descripcion,id_localidad,latitud,longitud) VALUES('Convento de San Francisco','Construida casi en su totalidad en el siglo XIV, esta iglesia conventual de los franciscanos es una obra maestra del arte de las órdenes mendicantes que llegaron a la ciudad en la época de su primer esplendor. Fue declarada monumento histórico-artístico en 1896. En su interior podemos destacar la sepultura de Paio Gómez Charino, trovador, almirante del mar, perteneciente a una de las familias nobles de la época.\n" +
                "\n" +
                "Según la tradición, el convento fue fundado por Francisco de Asís, que paró en Pontevedra mientras hacía la ruta Portuguesa del camino de Santiago. La edificación fue construida entre 1310 y 1360, contando con la ayuda económica de los herederos de Paio Gómez Chariño en un solar de la casa de Soutomaior, en aquella época aun fuera del perímetro de la muralla de la ciudad.\n" +
                "\n" +
                "La opulencia de esta construcción provocó envidia en los miembros de la orden dominica instalados en la ciudad, que habían rematado su iglesia diez años antes, y que decidieron iniciar en 1380 la construcción de otra iglesia mayor que la franciscana, con cinco ábsidas. Este gran apogeo en la construcción se debió al gran número de donaciones económicas procedentes de familias pudientes, temerosas de la muerte procedente de la peste bubónica que asoló Europa en esa época. Luego de la desamortización de Mendizábal el recinto quedó deshabitado, y en 1930 el templo fue cedido por Real Orden.\n" +
                "\n" +
                "La iglesia es de estilo gótico tardío u ojival, y fue declarada monumento histórico-artístico en 1896. Tiene planta de cruz la latina, con nave única, crucero, cubierta de madera y cabeceras con tres ábsides poligonales, cubiertas con bóvedas de crucería.',4,42.431365775388294, -8.643311119065995)";
        db.execSQL(SQLInsertPon6);

        String SQLInsertPon7="INSERT INTO lugares_interes(nombre,descripcion,id_localidad,latitud,longitud) VALUES('Con Negro','Con Negro ofrece, junto con el paseo, uno de los atardeceres más hermosos de San Vicente. Pese su escaso tamaño -apenas 40 metros-, su media concha te permite tener la sensación de estar aislado del bullicio de otras playas más urbanas durante prácticamente todo el verano. El entorno es casi virgen y parada ideal para aquellos que busquen tranquilidad.',4,42.463825967269564, -8.94335266812085)";
        db.execSQL(SQLInsertPon7);

        String SQLInsertPon8="INSERT INTO lugares_interes(nombre,descripcion,id_localidad,latitud,longitud) VALUES('Edificio Castelao','Edificio de reciente construcción que supone para el museo provincial una ampliación de diez mil metros cuadrados dedicados a salas de exposiciones permanentes y temporales, talleres de restauración, auditorio con capacidad para doscientas cuarenta personas y cafetería.\n" +
                "\n" +
                "Las obras de este inmueble se iniciaron en el año 2004 según el proyecto elaborado por los arquitectos Eduardo Pesquera y Jesús Ulargui, ganadores del concurso de ideas convocado por la Diputación de Pontevedra.\n" +
                "\n" +
                "En las veintitrés salas de exposición permanente encontrará el visitante la evolución del arte gallego desde el gótico hasta la actualidad, así como las manifestaciones artísticas realizadas en otros puntos de España desde los tiempos de Goya hasta mediados del s. XX.',4,42.43354727974957, -8.641947513080586)";
        db.execSQL(SQLInsertPon8);



        //Turismo Coruña

        String SQLInsertCo1="INSERT INTO lugares_interes(nombre,descripcion,id_localidad,latitud,longitud) VALUES('Torre de Hércules','Localizada en la misma ciudad de A Coruña, en su paseo marítimo. Desde su construcción por los romanos, el faro hoy conocido como Torre de Hércules fue un monumento digno de mención. Así lo recogen las crónicas romanas y las fuentes posteriores hasta la actualidad. Su singularidad hizo que la Torre se transformase en el símbolo de la ciudad de A Coruña, siendo asumido por todos sus vecinos e instituciones." +
                "Ahora, el faro más antiguo en funcionamiento del mundo, que alumbró con su presencia o su luz a miles de personas en los cientos de años de su existencia, es Patrimonio de la Humanidad.\n" +
                "\n" +
                "Faro de época romana (s. II d.C.), aunque podría haber una construcción fenicia anterior. Restaurado y con importantes reformas en los siglos XVII y XVIII.\n" +
                "\n" +
                "Exterior de planta cuadrada con ventanas. Se accede al interior por las excavaciones realizadas alrededor del faro y a la parte superior por una escalera que se convierte en escalera de caracol en el último tramo. Es visitable y tiene un museo en el interior.',5,43.385932055874605, -8.406567661342157)";
        db.execSQL(SQLInsertCo1);

        String SQLInsertCo2="INSERT INTO lugares_interes(nombre,descripcion,id_localidad,latitud,longitud) VALUES('Casa de las Ciencias en A Coruña','La Casa de las Ciencias tiene su sede en un palacete situado en el Parque de Santa Margarita. El edificio de planta octogonal tiene las salas dedicadas la exposiciones interactivas, y en la cúpula se encuentra el planetario. Este centro de ciencia interactivo, que fue el primero en España de titularidad pública, acerca la ciencia a los ciudadanos a través de módulos que responden a la acción del visitante con comportamientos que despiertan la curiosidad e invitan a exponer y resolver preguntas. \n" +
                "\n" +
                "El elemento más emblemático de este museo es su planetario digital, en el que se puede aprender a reconocer estrellas, constelaciones, planetas y otros objetos observables a simple vista. Los programas abordan todo tipo de cuestiones de astronomía y además cuenta con sesiones especiales para niños/as.',5,43.36210168405226, -8.412573566795256)";
        db.execSQL(SQLInsertCo2);

        String SQLInsertCo3="INSERT INTO lugares_interes(nombre,descripcion,id_localidad,latitud,longitud) VALUES('Aquarium Finisterrae','El Aquarium Finisterrae es un centro público de ciencia dedicado a la educación medioambiental y la divulgación científica de temas marinos.\n" +
                "\n" +
                "El tercero de los Museos Científicos Coruñeses tiene por objetivo promover el conocimiento del océano y educar actitudes de cariño hacia el mar y la vida marina. Fue creado por el Ayuntamiento de A Coruña el 5 de junio de 1999.\n" +
                "\n" +
                "El Aquarium Finisterrae cuenta con cuatro salas de exposiciones, cada una con personalidad propia, y una colección biológica compuesta por más de trescientas especies diferentes.',5,43.3835985835451, -8.409604932779807)";
        db.execSQL(SQLInsertCo3);

        String SQLInsertCo4="INSERT INTO lugares_interes(nombre,descripcion,id_localidad,latitud,longitud) VALUES('Domus-Casa del Hombre en A Coruña','La Domus es un museo interactivo dedicado de forma global y monográfica al ser humano, y se encuentra en el Paseo Marítimo de Riazor, en un edificio construido por el arquitecto japonés Arata Isozaki.\n" +
                "\n" +
                "La visita. Experimentar con la propia sombra, comprender por qué nos parecemos a nuestros progenitores, medir la velocidad de un tiro de penalti o contemplar imágenes de un parto real son algunas de las propuestas a descubrir durante la visita. La exposición \"Juegos de neuronas. Piezas de la inteligencia humana\" tiene como elemento más emblemático una colorida red neural elaborada con neuronas creadas en su mayor parte por escolares gallegos, y propone actividades que ponen en práctica las diferentes habilidades de las personas, como intentar relajarse para ganar en un juego que mide la actividad cerebral, realizar un dibujo siguiendo instrucciones verbales, o probar los reflejos y la agilidad en un panel con botones a diferentes alturas que hay que tocar cuándo se encienden.\n" +
                "\n" +
                "La sección dedicada a la evolución humana invita a conocer nuestros orígenes y las características que nos diferencian como especie. Permite llevar de recuerdo una foto de familia junto a nuestros antepasados homínidos o afinar la puntería con unos bisontes de Altamira.',5,43.3777818369346, -8.406645009523203)";
        db.execSQL(SQLInsertCo4);

        String SQLInsertCo5="INSERT INTO lugares_interes(nombre,descripcion,id_localidad,latitud,longitud) VALUES('El Castillo de Santo Antón','El Castillo de Santo Antón, antigua fortificación construida para la defensa de la ciudad de A Coruña, se sitúa frente el Paseo del Parrote, en la conocida como \"Illa da Pena Grande\". Durante su período insular (hasta los años 40 del siglo XX), Santo Antón se comunicó con la ciudad desde la Casa de Botes o de O Boteiro, actualmente habilitada como biblioteca del Museo. \n" +
                "\n" +
                "La colección. En 1960 el Ministerio del Ejército cedió el edificio al Ayuntamiento de A Coruña, creándose el Museo Arqueológico y Histórico de la ciudad, que abre sus puertas al público en 1968. De titularidad municipal, conserva y expone piezas de la prehistoria y de la historia relacionadas con el castillo, con la ciudad y con Galicia. La exposición consta de tres secciones: arte medieval y heráldica (acceso y patio de armas), arqueología (interior, planta baja), historia del edificio y de la ciudad (interior, planta baja y alta). La visita se ve complementada con el recorrido simultáneo por la arquitectura del castillo.\n" +
                "\n" +
                "La exposición que exhibe el Museo Arqueológico e Histórico tiene piezas de incalculable valor que abarcan desde los orígenes de la civilización en Galicia hasta la historia más moderna de la ciudad y de la provincia; un túnel del tiempo por descubrir paseando por las antiguas dependencias de la fortaleza.',5,43.365749439777595, -8.387784163070464)";
        db.execSQL(SQLInsertCo5);

        String SQLInsertCo6="INSERT INTO lugares_interes(nombre,descripcion,id_localidad,latitud,longitud) VALUES('Plaza de María Pita','La plaza fue proyectada por el arquitecto Juan de Ciórraga en 1877 tras el derrumbamiento de la muralla con el fin de resolver el paso de la ciudad vieja a la Pescadería. El recinto fue pavimentado en 1936 y asfaltado en la década de 1950 durante el mandato como alcalde de Alfonso Molina.\n" +
                "Antiguamente recibió el nombre de plaza de Alesón, Libertad y Derribo.\n" +
                "La plaza forma un gran rectángulo de más de 10 000 m². En una de sus frentes se encuentra el palacio del ayuntamiento, rodeado por las otras tres partes por edificios porticados y culminados con unas espléndidas galerías, típicas de la arquitectura gallega.\n" +
                "En el centro de la plaza se ubica una estatua de María Pita, se trata de una obra de Xosé Castiñeiras realizada en bronce.\n" +
                "En la obra se puede ver representada a la heroína coruñesa alzando la pica con la que según cuenta la historia mató al alférez inglés que dirigía el asalto sobre La Coruña.\n" +
                "Con la otra mano sujeta el cuerpo de su marido asesinado.',5,43.371183551941705, -8.39639244240281)";
        db.execSQL(SQLInsertCo6);

        String SQLInsertCo7="INSERT INTO lugares_interes(nombre,descripcion,id_localidad,latitud,longitud) VALUES('Playa de Riazor','Se trata de una céntrica playa de Bandera Azul y es la preferida de muchas familias con niños durante el verano, porque ofrece todas las comodidades para disfrutar de un día en el mar.\n" +
                "\n" +
                "Ese rasgo distintivo se debe a sus instalaciones y a que cuenta con numerosos servicios: paseo marítimo, alquiler de tumbonas, aseos, duchas, vigilancia, salvamento, socorrismo y primeros auxilios, además de parking y acceso para personas con movilidad reducida.\n" +
                "\n" +
                "Con 25 grados de temperatura media y teniendo el estadio de fútbol de Riazor a pie de playa permite disfrutar de un día completo sin apenas tener que desplazarse. No es de extrañar que su ocupación sea siempre altísima. Riazor es una playa ideal para practicar surf, por ser una playa ventosa con fuerte oleaje.',5,43.36874754932928, -8.41139718770007)";
        db.execSQL(SQLInsertCo7);

        String SQLInsertCo8="INSERT INTO lugares_interes(nombre,descripcion,id_localidad,latitud,longitud) VALUES('Monte de San Pedro','El monte de San Pedro ocupa una ubicación estratégica en la ría de A Coruña. Este extenso parque público, auténtico pulmón verde de la ciudad coruñesa, es fruto de diversos proyectos que empezaron a finales del siglo XX con el objetivo de recuperar un espacio de gran relevancia histórica y cultural." +
                "Su concepción como enclave militar hace que sea realmente singular, puesto que la propia monumentalidad de las instalaciones militares y su altura sobre el mar, ofrecen un aire diferente a este mirador natural sobre la ciudad.\n" +
                "\n" +
                "Desde esta atalaya a 142 metros sobre el nivel del mar y escoltados por los inmensos cañones de esta batería de costa que ahora señalan al horizonte, se trata de uno de los mejores atardeceres que ver en Galicia.',5,43.37736215117283, -8.43667614778045)";
        db.execSQL(SQLInsertCo8);





        //Restaurantes Santiago

        String SQLInsert_San_comer1="INSERT INTO donde_comer(nombre_restaurante,descripcion_restaurante,id_localidad,latitud,longitud) VALUES('Casa dos xacobes','Sorprende a tu paladar con los platos de Casa dos xacobes, está en la ciudad de Santiago de Compostela, su ubicación es inmejorable.\n" +
                "\n" +
                "La amplitud de su carta es la justa y necesaria para un restaurante de este estilo, merece la pena que visites el restaurante si te gusta la comida otras cocinas españolas, quédate con buen sabor de boca pidiendo su croquetas.\n" +
                "\n" +
                "La puntuación media es de 8.94, te sorprenderá gratamente los precios de este restaurante, no es un restaurante caro y su comida y servicio merecen mucho la pena, paga tu comida con tickets restaurante sin ningún problema.\n" +
                "\n"+
                "Llama para reservar si tienes planeado ir a mediodía." +
                "\n" +
                "Tiene una decoración cuidada y hogareña, las reuniones familiares siempre serán bienvenidas en este local, es normal que quieras volver a repetir nada más terminar.',1, 42.882473999999995,-8.541843)";
        db.execSQL(SQLInsert_San_comer1);


        String SQLInsert_San_comer2="INSERT INTO donde_comer(nombre_restaurante,descripcion_restaurante,id_localidad,latitud,longitud) VALUES('Restaurante Abrasador Gaia Medieval','Abrasador Gaia Medieval se encuentra en pleno centro histórico de Santiago de Compostela. Ofrece cocina de vanguardia y brasa con carnes a la parrilla de crianza propia, buenos arroces con marisco y algunos platos tradicionales de la cocina gallega, como el caldo gallego o la tortilla «Gaia» estilo Betanzos. Situado a tan solo 6 minutos a pie de la plaza do Obradoiro. Destaca por la atención de su equipo humano, que hace que te sientas como en casa. Si necesitas reservar, te recomendamos que lo hagas a través del botón de «Reserva digital» o  con la central de reservas telefónica. Y si quieres información del restaurante puedes llamar al número de teléfono 658263224 y preguntar por Almudena.',1,42.881646674287744, -8.548842355468292)";
        db.execSQL(SQLInsert_San_comer2);
        String SQLInsert_San_comer3="INSERT INTO donde_comer(nombre_restaurante,descripcion_restaurante,id_localidad,latitud,longitud) VALUES('Sicilia in Bocca','Si ama la cocina italiana y está buscando en la monumental ciudad coruñesa de Santiago de Compostela un lugar donde celebrar un evento especial, en el número 53 de la Avenida Rosalía de Castro, en un tranquilo barrio residencial nuevo, a 300 metros del casco histórico está Sicilia in Bocca, un establecimiento para amantes de la buena mesa.\n" +
                "\n" +
                "El restaurante Sicilia in Bocca le ofrece todo el sabor de Italia con un estilo de gastronomía tradicional donde cabe destacar más de 30 variedades de pizzas artesanales, calzones y focaccias XXL cocinadas en el horno de leña con ingredientes y masa de primera calidad, además de pastas frescas y secas elaboradas al más puro estilo italiano. En la carta puede elegir también entre un buen surtido de entrantes, ensaladas, hamburguesas de buey, carnes y pescados, postres y helados italianos. Todos los platos se pueden maridar con vinos de la bodega. Tienen un menú buffet por 12 euros que se incrementa hasta los 16 euros si quiere café y postre y servicio a domicilio.',1,42.874143600000004, -8.5522644)";
        db.execSQL(SQLInsert_San_comer3);
        String SQLInsert_San_comer4="INSERT INTO donde_comer(nombre_restaurante,descripcion_restaurante,id_localidad,latitud,longitud) VALUES('Garum Bistro','En el casco histórico de Santiago de Compostela, a pocos metros de la catedral, se encuentra el restaurante Garum Bistro, una salida gastronómica informal y acogedora con aires de taberna antigua que destaca por su decoración justa, que le entrega un ambiente recogido e íntimo para disfrutar de su comida. En su cocina las materias primas son de gran calidad y están trabajadas con técnicas de vanguardia dando lugar a platos variados y sabrosos con guiños a la cocina internacional',1,42.88367160000001,-8.5421467)";
        db.execSQL(SQLInsert_San_comer4);
        String SQLInsert_San_comer5="INSERT INTO donde_comer(nombre_restaurante,descripcion_restaurante,id_localidad,latitud,longitud) VALUES('Mesón 42','En plena Rúa do Franco (muy cerca de la Catedral de Santiago de Compostela) se encuentra tu restaurante de siempre adaptado a los tiempos actuales. El Mesón 42 es tu local de confianza para tomar unos vinos, unas cañas o sentarte a disfrutar de la cocina tradicional gallega preparada con mucho cariño. Somos una empresa familiar que en el año 2005 comenzamos a regentar el Mesón 42, un restaurante con mucha historia y tradición que ahora hemos remodelado sin que haya perdido su esencia. Nuestra base siempre ha sido el trabajo día a día y la confianza mutua con los clientes que en muchos casos se convierten en amigos y unos miembros más de la familia. Cuando entras en el Mesón 42 tienes la confianza de que todo va a ir sobre ruedas y solo te tienes que preocupar de sentarte y disfrutar.',1,42.877943599999995,-8.545454)";
        db.execSQL(SQLInsert_San_comer5);
        String SQLInsert_San_comer6="INSERT INTO donde_comer(nombre_restaurante,descripcion_restaurante,id_localidad,latitud,longitud) VALUES('O Tamboril','O Tamboril es una pequeña casa de comidas que, desde 2007, ofrece sus servicios en la parte nueva de Santiago de Compostela. A finales de ese mismo año, con la llegada de Cristóbal Rey para ponerse al mando de los fogones, el arroz fue ganando cada vez más protagonismo entre las propuestas del restaurante, hasta convertirse en una especialidad que comparte carta con otros platos tal vez menos reconocidos, pero igual de cuidados y sabrosos. O Tamboril es, además, una gran familia en la que clientes, amigos, proveedores y cada una de las personas que forman y formaron parte del equipo representan una parte igual de importante.',1,42.8734967,-8.545437999999999)";
        db.execSQL(SQLInsert_San_comer6);
        String SQLInsert_San_comer7="INSERT INTO donde_comer(nombre_restaurante,descripcion_restaurante,id_localidad,latitud,longitud) VALUES('O Sendeiro','Cocina gallega de temporada con un toque personal. Situado en una casa de piedra, antigua curtiduría del siglo XIX, este gallego es idóneo para comer a base de tapas o platos informales y degustar los mejores vinos de la región. En su carta destacan los pescados y mariscos como el pulpo, las vieiras o la lubina. También es posible encontrar buenos platos de carne como la \"croca\" de ternera, o un buen chuletón. Dispone de un patio interior rodeado de piedra y plantas que resulta muy agradable y de dos reservados para grupos. El personal es muy atento, y explica cada plato, lo que facilita la elección. Platos con sabor, color y pasión y postres caseros.',1,42.8754437,-8.5393105)";
        db.execSQL(SQLInsert_San_comer7);
        String SQLInsert_San_comer8="INSERT INTO donde_comer(nombre_restaurante,descripcion_restaurante,id_localidad,latitud,longitud) VALUES('La Tita','Conocido por locales y turistas como el bar que sirve las mejores tortillas de Santiago de Compostela, que puedes degustar como tapa gratis con la bebida, y pagándola si pides media o una ración, este pequeño local con terraza es uno de los imprescindibles en la ciudad.',1,42.877867800000004,-8.5441535)";
        db.execSQL(SQLInsert_San_comer8);


        //Restaurantes Vigo
        String SQLInsert_Vi_comer1="INSERT INTO donde_comer(nombre_restaurante,descripcion_restaurante,id_localidad,latitud,longitud) VALUES('Epoca Restaurante Peruano Fusión','Época Restaurante Peruano Fusión en Vigo donde se unen la cocina gallega y peruana." +
                "Algunos platos de sus platos son:\n" +
                "\n" +
                "- Ensalada de verduritas y frutas frescas*\n" +
                "- Empanada de solomillo de buey con tetilla arzúa y especies andinas\n" +
                "- Patata Andina fusionada con especies Andinas, vestresca de bonito, aguacate, camote, camote, mayonesa e hilos de wantán frito\n" +
                "- Pulpo de la Ría en fusión al oliva y salsa andinas\n" +
                "- Entrecot de ternera Gallega\n" +
                "- Cochinillo en caja china',2,42.232754799999995,-8.7160608)";
        db.execSQL(SQLInsert_Vi_comer1);
        String SQLInsert_Vi_comer2="INSERT INTO donde_comer(nombre_restaurante,descripcion_restaurante,id_localidad,latitud,longitud) VALUES('Os Padróns','Os Padróns en Vigo, un gastrobar que fusiona las diferentes gastronomías del mundo en un pan de hamburguesa.\n" +
                "\n" +
                "Disfrutar de México es posible con su cochinita pibil de cerdo ibérico y guacamole. Viajar por la ría con su pulpo a feira con tetilla o su hamburguesa de ternera gallega certificada sin conservantes ni aditivos. Pasear por Japón con el pollo yakitori con teriyaki de naranja y mayonesa de kimchie. Disfrutar de una hamburguesas al más puro estilo americano, con ese pan blando condimentado con los mejores ingredientes.\n" +
                "\n" +
                "En Os Padróns podrás gozar de una gran variedad de hamburguesas de calidad, elaboradas por ellos mismos, o de sus postres artesanales que te permiten experimentar con los cinco sentidos.',2,42.2218691,-8.7311097)";
        db.execSQL(SQLInsert_Vi_comer2);
        String SQLInsert_Vi_comer3="INSERT INTO donde_comer(nombre_restaurante,descripcion_restaurante,id_localidad,latitud,longitud) VALUES('Restaurante Valdevez','El restaurante Valdevez es de esas tabernas de guisos de siempre, de esos que guardan un aire castizo pero que depuran y ajustan con una grácil evolución técnica.\n" +
                "Productos de la tierra y de temporada, platos notables y querencia por una cocina con carácter. Esa delicadeza que prueba un desarrollo constante que no pierde de vista las raíces. Símbolos típicos de la casa: los langostinos Valdevez, el carpaccio de reno con virutas de foie, el cochinillo confitado y la empanada de centolla.\n" +
                "Un pequeño lugar en el Casco vello de Vigo un tanto ecléctico de cálido ambiente y un trato cercano y profesional. El claro ladrillo de las paredes y las vigas y marcos de madera aportan un encuadre encantador. Dispone de lugar reservado para cenas de grupo.',2,42.2396653,-8.7256688)";
        db.execSQL(SQLInsert_Vi_comer3);
        String SQLInsert_Vi_comer4="INSERT INTO donde_comer(nombre_restaurante,descripcion_restaurante,id_localidad,latitud,longitud) VALUES('Trepia gastronomía','Restaurante Trepia gastronomía de Vigo, una cocina diferente y original con sabores tradicionales e innovadores. Su ubicación te permite disfrutar del Casco Vello de Vigo, en un ambiente protagonizado por su decoración contemporánea.\n" +
                "En Trepia insisten en hacer las cosas con esmero, y eso se nota en el servicio que ofrecen. Sus profesionales estarán dispuestos a resolver cualquier tipo de duda y a conseguir una cocina impecable.\n" +
                "El restaurante cuenta con cómodos espacios pensados para hacer de tu experiencia una ocasión única. Podrás disfrutar además de una carta variada tanto para compartir, picar o de plato. Siempre perfectamente presentados con sabores y texturas asombrosas.',2,42.23846470000001,-8.724795)";
        db.execSQL(SQLInsert_Vi_comer4);
        String SQLInsert_Vi_comer5="INSERT INTO donde_comer(nombre_restaurante,descripcion_restaurante,id_localidad,latitud,longitud) VALUES('Nikko','El restaurante Nikko en Vigo es un espacio universal que ha sabido hacer de la cocina japonesa fusión toda una experiencia de descubrimiento incesante.\n" +
                "Compensan, con maestría, los platos más tradicionales de la gastronomía nipona con el producto atlántico de lonja.\n" +
                "El chef Nico Pio rompe con la tradicional ortodoxia japonesa. En sus elaboraciones se origina una constante desenvoltura y frescura, fruto del deseo de renovarse. Su cocina se distancia del patrón establecido, fundiendo ingredientes de aquí y de allá, que forman platos de sabores definidos y precisos.\n" +
                "Su principal protagonista es la barra de sushi. El producto y las manos más hábiles son las protagonistas del espectáculo culinario. La experiencia finaliza con una pequeña selección de vinos blancos y espumosos y sus postres.\n" +
                "Una amplia carta, detallada para todo tipo de preferencia y con variedad en su menú del día. Además, podrás hacer tu reserva para no quedar sin mesa o solicitar tu pedido para llevar.',2,42.2335364,-8.7152678)";
        db.execSQL(SQLInsert_Vi_comer5);
        String SQLInsert_Vi_comer6="INSERT INTO donde_comer(nombre_restaurante,descripcion_restaurante,id_localidad,latitud,longitud) VALUES('Casa Obdulia','Este restaurante te ofrece estupendos platos de las cocinas mediterránea y española. Basándonos en las opiniones de los clientes, aquí sus camareros te sirven un sorprendente juane, una tierna merluza y un sabroso laing. Prueba su delicada compota.\n" +
                "La carta de vinos es muy variada: hay que satisfacer las necesidades de todos los visitantes. Elige un extraordinario café cortado: no lo vas a lamentar. Muchos comensales destacan que el personal es amable en Casa Obdulia. Te va a gustar su agradable servicio. Según el criterio de los usuarios, sus precios son razonables.\n',2,42.2513377,-8.6891891)";
        db.execSQL(SQLInsert_Vi_comer6);
        String SQLInsert_Vi_comer7="INSERT INTO donde_comer(nombre_restaurante,descripcion_restaurante,id_localidad,latitud,longitud) VALUES('La pepita','La Pepita es un sello de calidad y todo un acontecimiento en la ciudad, porque ha calado profundamente entre  los vigueses. Si hablamos de gastronomía, tenemos que destacar la calidad de sus carnes a la parrilla de ternera, buey, cerdo ibérico o pollo, la riqueza de sus vegetales y el sabor se sus salsas. En cuanto al pan, podremos elegir entre el clásico de  hamburguesa con semillas de amapola o el típico pan artesano. Otro elemento a destacar es la calidez de los locales , predominan los tonos ocres y la decoración sencillamente divertida que crea ambientes muy agradables. El resto de los detalles, incluida la música exquisitamente  elegida son el colmo de la perfección.\n" +
                "De la pepita ya se puede disfrutar en muchos locales en toda España, y si estamos en Vigo podremos visitar el establecimiento original de la céntrica calle Oporto donde empezó todo lo que muchos han intentado repetir posteriormente. Otro espacio para vivir La Pepita es el del Corte Inglés de Vigo,  un lugar ideal para hacer una parada en un día de compras.',2,42.2374174,-8.716334699999999)";
        db.execSQL(SQLInsert_Vi_comer7);
        String SQLInsert_Vi_comer8="INSERT INTO donde_comer(nombre_restaurante,descripcion_restaurante,id_localidad,latitud,longitud) VALUES('A pedra','La amplitud de su carta es la justa y necesaria para un restaurante de este estilo, no te quedes sin probar su pulpo.\n" +
                "En Gastroranking tiene una puntuación de 8.22, los precios que maneja esta restaurante son razonables, sus precios no son elevados y su comida lo merece, aquí podrás pagar tanto en efectivo como con tarjeta.\n" +
                "No te olvides de reservar tu mesa, sobre todo los fines de semana.\n" +
                "El local está decorado de forma agradable, puedes disfrutar de su agradable terraza, es el lugar adecuado para venir con niños, no tenemos dudas de que saldrás del restaurante con un buen sabor de boca.',2,42.2387538,-8.7262807)";
        db.execSQL(SQLInsert_Vi_comer8);



        //Restaurantes Lugo
        String SQLInsert_Lu_comer1="INSERT INTO donde_comer(nombre_restaurante,descripcion_restaurante,id_localidad,latitud,longitud) VALUES('Bar Restaurante Parrilla Argentina Caminito','La cocina argentina es lo que a sus clientes más les atrae de este restaurante. En Restaurante Caminito, sus comensales pueden probar una singular ternera a la parrilla, un tierno asado y una atrayente parrillada. Sus delicados helados te van a impresionar desde el primer bocado. En este lugar, sus visitantes pueden tomar un sensacional vino. Su espectacular café cortado hará que tu comida parezca aún mejor, lo que, con seguridad, te hará volver.\n" +
                "Muchos críticos apuntan que los camareros y camareras son abnegados en este lugar. Su estupendo servicio te hará sentirte especial. Los asiduos de este restaurante dicen que sus precios les han parecido bajos. Cuando entres en este establecimiento, presta atención a su hogareño ambiente.',3,43.0194206,-7.558568899999999)";
        db.execSQL(SQLInsert_Lu_comer1);

        String SQLInsert_Lu_comer2="INSERT INTO donde_comer(nombre_restaurante,descripcion_restaurante,id_localidad,latitud,longitud) VALUES('La pizzeria di Totó','El restaurante TOTÓ representa la esencia de la cocina italiana.\n" +
                "Pastas tradicionales, recetas de toda la vida, verduras frescas y buenos vinos. Todo ambientado alrededor de un piano y música en vivo.\n" +
                "Es siempre una experiencia agradable tomar su bien preparado tiramisú, su sorprendente pizza con nutella o sus caseros helados. Algunos de sus invitados recomiendan probar la espectacular cerveza de La pizzeria di Totó.',3,42.9948349,-7.553145600000001)";
        db.execSQL(SQLInsert_Lu_comer2);
        String SQLInsert_Lu_comer3="INSERT INTO donde_comer(nombre_restaurante,descripcion_restaurante,id_localidad,latitud,longitud) VALUES('Pasarela','Este restaurante te ofrece buenos platos y un lugar donde descansar tras un largo paseo alrededor de Domus del Mitreo. Su cocina española atrae a comensales que buscan nuevas experiencias. Siempre puedes degustar unas bien trabajadas tapas, un generoso laing o un atrayente rape: son la especialidad de Pasarela.\n" +
                "Es fácil encontrar este lugar gracias a su gran ubicación. Basándonos en las opiniones de los usuarios, aquí sus camareros ofrecen un bien valorado café. Su cordial personal te da la bienvenida en este lugar todo el año.\n',3,43.008004199999995,-7.5601894)";
        db.execSQL(SQLInsert_Lu_comer3);
        String SQLInsert_Lu_comer4="INSERT INTO donde_comer(nombre_restaurante,descripcion_restaurante,id_localidad,latitud,longitud) VALUES('La Urbana','La Urbana Lugo es un Restaurante que ofrece, como producto estrella, hamburguesas artesanas de calidad extraordinaria, que se alejan de la industrialización que suele existir en las cadenas o franquicias de este sector. Sus hamburguesas son creadas por los mejores chefs para deleitarnos y sorprendernos con frecuencia con combinaciones novedosas.\n" +
                "Están situados dentro del Centro Comercial As Termas, en una zona tranquila que al mismo tiempo se posiciona como la mejor opción para los cinéfilos.\n" +
                "Todas las hamburguesas comparten un denominador común: Productos de la huerta y carne 100% natural.\n" +
                "Cuentan con un menú para los más pequeños que incluye mini hamburguesa con carne ecológica, unos estupendos postres Casa Grande de Xanceda y un regalito sorpresa.',3,43.007392499999995,-7.5563978)";
        db.execSQL(SQLInsert_Lu_comer4);
        String SQLInsert_Lu_comer5="INSERT INTO donde_comer(nombre_restaurante,descripcion_restaurante,id_localidad,latitud,longitud) VALUES('O Xugo','La Pulpería-Parrillada O Xugo es uno de los restaurantes más versátiles de Lugo. Situado en zona céntrica, justo al lado del Parque de Rosalía, uno de los parques principales de la ciudad.\n" +
                "La Pulpería O Xugo dispone de un amplísimo comedor y de una variada carta con una increíble relación calidad-precio. Asimismo, cuenta con menú del día y diversos menús para grupos numerosos, a la elección de los comensales.\n" +
                "Un local cómodo y amplio que, junto con su amplio menú, lo convierte en un local perfecto para organizar comidas de empresa o familiares.\n" +
                "Cabe destacar de forma notable sus especialidades: la carne a la brasa y el pulpo. Dispone de pescado fresco y multitud de raciones para todos los gustos.',3,43.0047946,-7.5590432000000005)";
        db.execSQL(SQLInsert_Lu_comer5);
        String SQLInsert_Lu_comer6="INSERT INTO donde_comer(nombre_restaurante,descripcion_restaurante,id_localidad,latitud,longitud) VALUES('Mesón da Rúa','Su cocina española, bajo la dirección de su popular chef, es aquí exquisita. Es una estupenda idea pedir unos sorprendentes calamares, una sabrosa tortilla de patata y unas generosas tapas. La receta del éxito de este restaurante está en su atrayente pastel de frutas y su bien preparada tarta de santiago.\n" +
                "Es fácil encontrar Mesón da Rúa gracias a su gran ubicación. Es estupendo poder probar una insuperable sidra, una sensacional cerveza o un excelente vino. Su extraordinario café te está esperando en este lugar. Muchos clientes aseguran que el personal es acogedor. Un admirable servicio es siempre un plus importante. Los precios son justos para la calidad que te dan. Una decoración cuidada y su ambiente delicado ayudan a sus clientes a sentirse relajados.\n',3,43.0107352,-7.5589935)";
        db.execSQL(SQLInsert_Lu_comer6);
        String SQLInsert_Lu_comer7="INSERT INTO donde_comer(nombre_restaurante,descripcion_restaurante,id_localidad,latitud,longitud) VALUES('O tentaculo','Pulpería y restaurante de comida tradicional y gallega en pleno corazón de Lugo. Tapas, raciones, pulpo, menú del día, comida por encargo y para llevar con recogida en el local. Platos de gran elaboración y cocinados lentamente para mantener las propiedades de los alimentos y un sabor intenso.',3,43.010329399999996,-7.5589249)";
        db.execSQL(SQLInsert_Lu_comer7);
        String SQLInsert_Lu_comer8="INSERT INTO donde_comer(nombre_restaurante,descripcion_restaurante,id_localidad,latitud,longitud) VALUES('Casa D Auga','Restaurante de cocina gallega con un punto de creatividad situado en el centro de la ciudad de Lugo. Levantado sobre un edificio histórico del S.XVII, conserva restos romanos in situ del S.XIII como un pozo y una letrina. La cocina que ofrece se basa en productos naturales y de alta calidad provenientes de la tierra. Más de 19 años en el sector (desde 2004).',3,43.010384599999995,-7.5599300000000005)";
        db.execSQL(SQLInsert_Lu_comer8);
        String SQLInsert_Lu_comer9="INSERT INTO donde_comer(nombre_restaurante,descripcion_restaurante,id_localidad,latitud,longitud) VALUES('Restaurante Paprica','El Restaurante Paprica es un lugar perfecto para celebrar vuestra boda en pleno corazón de la ciudad de Lugo. Con una decoración minimalista y muy cuidada se reunirán con vosotros para que les contéis cómo queréis celebrar vuestra boda y se adaptarán a vuestros gustos y peticiones y lo prepararán todo para que todo salga perfecto en ese día tan especial para vosotros.\n" +
                "Os darán dos opciones. Llevar la comida del banquete al sitio que vosotros escogéis y os lo servirán para que no os tengáis que preocupar de nada o servir el banquete en el propio restaurante. Si os decantáis por la segunda opción, podréis cerrar el Restaurante y su acogedora terraza para vuestra boda, o solo uno de los dos espacios.\n" +
                "La cocina del Restaurante Paprica es de mercado y adaptan sus menús a los productos de cada temporada. En su selección de paltos ya cuentan con algunos que se han convertido en seña de identidad del local.\n" +
                "Para acceder al Restaurante hay que atravesar la bodega y la cocina. Seguramente este nuevo concepto de distribución del local sorprenda a todos vuestros invitados.',3,43.01077140033981, -7.553722126223843)";
        db.execSQL(SQLInsert_Lu_comer9);


        //Restaurantes Pontevedra

        String SQLInsert_Pon_comer1="INSERT INTO donde_comer(nombre_restaurante,descripcion_restaurante,id_localidad,latitud,longitud) VALUES('Pepe Vieira','Situado en Raxó, el restaurante Pepe Vieira es un verdadero referente gastronómico en la región. Galardonado con una estrella Michelin, este lugar ofrece una experiencia culinaria excepcional. El chef Pepe Vieira combina la tradición culinaria gallega con técnicas modernas y creativas para crear platos innovadores y deliciosos. Los ingredientes locales frescos son cuidadosamente seleccionados y transformados en creaciones gastronómicas únicas. El ambiente es elegante y sofisticado, lo que lo convierte en una opción perfecta para ocasiones especiales.',4,42.4090592,-8.754442400000002)";
        db.execSQL(SQLInsert_Pon_comer1);

        String SQLInsert_Pon_comer2="INSERT INTO donde_comer(nombre_restaurante,descripcion_restaurante,id_localidad,latitud,longitud) VALUES('Casa Solla','Ubicado en Poio, Casa Solla es otro restaurante galardonado con una estrella Michelin en la provincia de Pontevedra. Dirigido por el chef Pepe Solla, este establecimiento se enorgullece de ofrecer una cocina gallega contemporánea de alta calidad. Los platos son una fusión de tradición y vanguardia, utilizando productos locales frescos y de temporada. La presentación meticulosa, los sabores audaces y la atención al detalle hacen de Casa Solla una experiencia gastronómica inolvidable.\n',4,42.4333709,-8.669009899999999)";
        db.execSQL(SQLInsert_Pon_comer2);

        String SQLInsert_Pon_comer3="INSERT INTO donde_comer(nombre_restaurante,descripcion_restaurante,id_localidad,latitud,longitud) VALUES('Maruja Limón','Situado en el corazón del casco antiguo de Pontevedra, el restaurante Maruja Limón destaca por su cocina de autor. El talentoso chef Juan Crujeiras combina ingredientes locales frescos con técnicas culinarias innovadoras para crear platos sorprendentes y llenos de sabor. El menú varía según la temporada, lo que garantiza que cada visita sea una experiencia única. El ambiente es acogedor y moderno, y el servicio es atento y amable.',4,42.2403468,-8.723824)";
        db.execSQL(SQLInsert_Pon_comer3);

        String SQLInsert_Pon_comer4="INSERT INTO donde_comer(nombre_restaurante,descripcion_restaurante,id_localidad,latitud,longitud) VALUES('Eirado Da Leña','Ubicado en el centro de Pontevedra, el restaurante Eirado Da Leña es un lugar encantador que se especializa en cocina gallega tradicional. Aquí podrás disfrutar de platos caseros elaborados con ingredientes frescos y de alta calidad. Desde el famoso pulpo a la gallega hasta las empanadas recién horneadas, cada bocado te transportará al corazón de la cocina gallega. El ambiente es acogedor y familiar, perfecto para disfrutar de una comida reconfortante.\n',4,42.432601,-8.643374999999999)";
        db.execSQL(SQLInsert_Pon_comer4);

        String SQLInsert_Pon_comer5="INSERT INTO donde_comer(nombre_restaurante,descripcion_restaurante,id_localidad,latitud,longitud) VALUES('O Pote','Con una ubicación privilegiada junto al río Lérez, el restaurante O Pote es conocido por su excelente marisco fresco y pescado. Este establecimiento ofrece una experiencia gastronómica única, con platos elaborados con los mejores ingredientes del mar. El ambiente es relajado y agradable, y las vistas panorámicas del río crean un escenario encantador para disfrutar de una comida inolvidable.',4,42.7940197,-8.2850416)";
        db.execSQL(SQLInsert_Pon_comer5);

        String SQLInsert_Pon_comer6="INSERT INTO donde_comer(nombre_restaurante,descripcion_restaurante,id_localidad,latitud,longitud) VALUES('Casa Román','Situado en un edificio histórico en el centro de Pontevedra, Casa Román es un restaurante que combina la cocina gallega y española en un entorno encantador. Aquí encontrarás platos tradicionales como la merluza a la romana o el cordero asado, preparados con dedicación y respeto por los sabores auténticos. La atmósfera en Casa Román es acogedora y tradicional, con una decoración que refleja la rica historia de la región. Es un lugar perfecto para disfrutar de una comida en familia o con amigos, saboreando la esencia de la cocina local.',4,37.385171299999996,-5.9896825)";
        db.execSQL(SQLInsert_Pon_comer6);

        String SQLInsert_Pon_comer7="INSERT INTO donde_comer(nombre_restaurante,descripcion_restaurante,id_localidad,latitud,longitud) VALUES('Don Alex','Este restaurante familiar se encuentra en la encantadora localidad de Bueu, cerca de Pontevedra. Don Alex es conocido por su auténtica cocina gallega casera. Los platos son generosos y llenos de sabor, y se destacan especialidades como el caldo gallego, la chuleta de ternera y el pulpo a la brasa. El ambiente es cálido y acogedor, con un servicio amable y cercano que te hará sentir como en casa.',4,42.4298846,-8.6446202)";
        db.execSQL(SQLInsert_Pon_comer7);

        String SQLInsert_Pon_comer8="INSERT INTO donde_comer(nombre_restaurante,descripcion_restaurante,id_localidad,latitud,longitud) VALUES('Rías Baixas','Ubicado en el centro de Pontevedra, el Restaurante Rías Baixas es conocido por su auténtica cocina gallega y su ambiente acogedor. Este restaurante familiar ofrece una amplia variedad de platos tradicionales gallegos preparados con ingredientes frescos y de alta calidad. Su menú destaca por su selección de mariscos frescos, pescados de la región y carnes a la parrilla. Además, ofrecen una excelente carta de vinos, incluyendo opciones locales para acompañar las comidas. Con un servicio amable y precios razonables, el Restaurante Rías Baixas es una opción popular tanto para los residentes locales como para los visitantes que desean disfrutar de la auténtica cocina gallega en un ambiente agradable y acogedor.',4,42.4301075,-8.6426283)";
        db.execSQL(SQLInsert_Pon_comer8);

        String SQLInsert_Pon_comer9="INSERT INTO donde_comer(nombre_restaurante,descripcion_restaurante,id_localidad,latitud,longitud) VALUES('Casa Marco','Ubicado en el corazón de Pontevedra, el Restaurante Casa Marco es conocido por su cocina tradicional gallega y su ambiente acogedor. Este restaurante familiar ha estado sirviendo platos caseros deliciosos durante décadas. Su menú ofrece una amplia variedad de platos gallegos, desde mariscos frescos hasta carnes y pescados preparados a la parrilla. Casa Marco se enorgullece de utilizar ingredientes locales de alta calidad y recetas transmitidas de generación en generación. Es un lugar ideal para disfrutar de una comida auténtica y sabrosa en un entorno familiar y agradable.',4,42.4298846,-8.6446202)";
        db.execSQL(SQLInsert_Pon_comer9);




        String SQLInsert_Coruña_comer1="INSERT INTO donde_comer(nombre_restaurante,descripcion_restaurante,id_localidad,latitud,longitud) VALUES('Parrillada Milongas','La cadena de restaurantes que comenzó en Santiago en 2016 ofrece menús de churrasco, chuletones e infantiles perfectos para una comida en familia.\n" +
              "Come todo el churrasco que quieras en A Coruña. La Parrillada Milongas ofrece en su local en el Parque Europa una fusión de la tradición de carne argentina y gallega y es un local ideal para familias con área de juegos para niños.\n" +
              "En la carta destacan el churrasco sin límites y chuletones de vaca y ternera gallega, siempre acompañados de patatas, ensalada y postre o café. Aunque también hay opciones de pescado y marisco y todo a un precio muy accesible. \"El ticket por persona ronda los 15 euros\", indica el gerente, Cristian Guibelalde.',5,43.3554202,-8.3990923)";
        db.execSQL(SQLInsert_Coruña_comer1);

        String SQLInsert_Coruña_comer2="INSERT INTO donde_comer(nombre_restaurante,descripcion_restaurante,id_localidad,latitud,longitud) VALUES('Alborada','Situado en la playa de Riazor, el Restaurante Alborada es un lugar imprescindible para los amantes de la alta cocina. Con una estrella Michelin, el chef Iván Domínguez ofrece una experiencia culinaria excepcional. Su enfoque se centra en resaltar los sabores auténticos de los ingredientes locales gallegos a través de técnicas innovadoras. Los platos son creativos y visualmente impresionantes, y la atención al detalle es evidente en cada presentación. Además, el restaurante ofrece vistas impresionantes del mar, lo que lo convierte en un lugar perfecto para una velada romántica o una ocasión especial.',5,43.362343599999996,-8.4115401)";
        db.execSQL(SQLInsert_Coruña_comer2);

        String SQLInsert_Coruña_comer3="INSERT INTO donde_comer(nombre_restaurante,descripcion_restaurante,id_localidad,latitud,longitud) VALUES('Taberna O Fragón','Ubicada en el casco antiguo de A Coruña, la Taberna O Fragón es un lugar popular para disfrutar de platos tradicionales gallegos a precios razonables. Este acogedor restaurante se especializa en tapas y raciones, que van desde pulpo a la gallega y empanadas caseras hasta croquetas y pimientos de Padrón. La calidad de la comida es excelente y las porciones son generosas. Además, su ambiente animado y su servicio amable hacen de O Fragón un lugar ideal para compartir una comida con amigos o familiares sin gastar demasiado.',5,42.9234703,-9.2723785)";
        db.execSQL(SQLInsert_Coruña_comer3);

        String SQLInsert_Coruña_comer4="INSERT INTO donde_comer(nombre_restaurante,descripcion_restaurante,id_localidad,latitud,longitud) VALUES('Árbore da Veira','Ubicado en el centro de la ciudad, el Restaurante Árbore da Veira es otro establecimiento galardonado con una estrella Michelin. El chef Luis Veira combina ingredientes locales de alta calidad con técnicas culinarias contemporáneas para crear platos que sorprenden y deleitan a los comensales. La cocina se basa en los sabores auténticos de Galicia, destacando los productos del mar. La presentación es impecable y el servicio es atento, lo que contribuye a una experiencia gastronómica excepcional.',5,43.3775025,-8.433088099999999)";
        db.execSQL(SQLInsert_Coruña_comer4);

        String SQLInsert_Coruña_comer5="INSERT INTO donde_comer(nombre_restaurante,descripcion_restaurante,id_localidad,latitud,longitud) VALUES('O Lagar da Estrella',' Situado en un edificio histórico en la Ciudad Vieja, O Lagar da Estrella es un restaurante encantador que ofrece una experiencia culinaria tradicional gallega. Su ambiente rústico y acogedor crea un entorno perfecto para disfrutar de platos caseros deliciosos. El menú se basa en ingredientes frescos y locales, y destaca por su amplia selección de mariscos frescos, pescados y empanadas caseras. Es un lugar ideal para sumergirse en la cultura gastronómica gallega y disfrutar de la autenticidad de la cocina local.',5,43.3688429,-8.403396599999999)";
        db.execSQL(SQLInsert_Coruña_comer5);

        String SQLInsert_Coruña_comer6="INSERT INTO donde_comer(nombre_restaurante,descripcion_restaurante,id_localidad,latitud,longitud) VALUES('Bido','Ubicado cerca del puerto deportivo, el Restaurante Bido es conocido por su cocina casera gallega con un toque moderno. El ambiente es acogedor y familiar, con una decoración sencilla y cálida. El menú ofrece una variedad de platos que resaltan los sabores auténticos de Galicia. Entre sus especialidades se encuentran los mariscos frescos, los pescados de la región y las carnes a la parrilla. Además, cuentan con una amplia selección de vinos locales para complementar la comida. El servicio es amable y el precio es asequible, lo que lo convierte en una opción popular tanto para los lugareños como para los visitantes.',5,43.3623043,-8.405805299999999)";
        db.execSQL(SQLInsert_Coruña_comer6);

        String SQLInsert_Coruña_comer7="INSERT INTO donde_comer(nombre_restaurante,descripcion_restaurante,id_localidad,latitud,longitud) VALUES('O Retiro da Costiña','Si buscas una experiencia culinaria tranquila y relajante, O Retiro da Costiña es el lugar perfecto. Situado en un entorno natural a las afueras de A Coruña, este restaurante ofrece platos tradicionales gallegos en un ambiente idílico. Sus especialidades incluyen pulpo a la gallega, carne asada y tortillas caseras, todos preparados con ingredientes frescos y de alta calidad. Además, el restaurante cuenta con un hermoso jardín donde podrás disfrutar de tu comida al aire libre, rodeado de naturaleza.',5,43.033457899999995,-8.8039045)";
        db.execSQL(SQLInsert_Coruña_comer7);

        //String SQLInsert_Coruña_comer8="INSERT INTO donde_comer(nombre_restaurante,descripcion_restaurante,id_localidad,latitud,longitud) VALUES('A Estación','Situado en un antiguo edificio de la estación de tren de A Coruña, el Restaurante A Estación combina historia y gastronomía en un entorno encantador. Su cocina se centra en platos tradicionales gallegos con un toque creativo. El chef busca resaltar los sabores auténticos de los productos locales a través de técnicas culinarias innovadoras. Con una atmósfera elegante y un servicio impecable, A Estación es ideal para ocasiones especiales o cenas románticas.',5)";
        //db.execSQL(SQLInsert_Coruña_comer8);

        //String SQLInsert_Coruña_comer8="INSERT INTO donde_comer(nombre_restaurante,descripcion_restaurante,id_localidad,latitud,longitud) VALUES('Maruja Limón','Ubicado en el corazón de A Coruña, el Restaurante Maruja Limón ofrece una propuesta gastronómica fresca y moderna. Su chef, Juan Crujeiras, fusiona la cocina gallega con influencias internacionales, creando platos únicos y llenos de sabor. La carta destaca por su variedad de mariscos frescos, pescados de temporada y carnes de calidad. Además, el restaurante se distingue por su cuidada presentación y su atención al detalle, ofreciendo una experiencia gastronómica sofisticada y memorable.',5)";
        //db.execSQL(SQLInsert_Coruña_comer8);

        //Rutas


        String SQLInsert_San_ruta1 = "INSERT INTO rutas (nombre_ruta, descripcion_ruta, dificultad, tiempo_transcurrido, distancia, id_localidad) " +
                "VALUES ('Ruta Santiago', 'Ruta por Santiago','Moderada', '1 hora', '12 km', 1)";
        db.execSQL(SQLInsert_San_ruta1);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion < 2) {
            db.execSQL("ALTER TABLE donde_comer ADD COLUMN latitud REAL");
            db.execSQL("ALTER TABLE donde_comer ADD COLUMN longitud REAL");

            ContentValues santiago_comer_actualizado1 = new ContentValues();
            santiago_comer_actualizado1.put("latitud", 42.882473999999995);
            santiago_comer_actualizado1.put("longitud", -8.541843);
            String whereClause = "nombre_restaurante = ?";
            String[] whereArgs = { "Casa dos xacobes" };
            db.update("donde_comer", santiago_comer_actualizado1, whereClause, whereArgs);

            ContentValues santiago_comer_actualizado2 = new ContentValues();
            santiago_comer_actualizado2.put("latitud", 42.881646674287744);
            santiago_comer_actualizado2.put("longitud", -8.548842355468292);
            String whereClause2 = "nombre_restaurante = ?";
            String[] whereArgs2 = { "Restaurante Abrasador Gaia Medieval" };
            db.update("donde_comer", santiago_comer_actualizado2, whereClause2, whereArgs2);

            ContentValues santiago_comer_actualizado3 = new ContentValues();
            santiago_comer_actualizado3.put("latitud", 42.874143600000004);
            santiago_comer_actualizado3.put("longitud", -8.5522644);
            String whereClause3 = "nombre_restaurante = ?";
            String[] whereArgs3 = { "Sicilia in Bocca" };
            db.update("donde_comer", santiago_comer_actualizado3, whereClause3, whereArgs3);

            ContentValues santiago_comer_actualizado4 = new ContentValues();
            santiago_comer_actualizado4.put("latitud", 42.88367160000001);
            santiago_comer_actualizado4.put("longitud", -8.5421467);
            String whereClause4 = "nombre_restaurante = ?";
            String[] whereArgs4 = { "Garum Bistro" };
            db.update("donde_comer", santiago_comer_actualizado4, whereClause4, whereArgs4);

            ContentValues santiago_comer_actualizado5 = new ContentValues();
            santiago_comer_actualizado5.put("latitud", 42.877943599999995);
            santiago_comer_actualizado5.put("longitud", -8.545454);
            String whereClause5 = "nombre_restaurante = ?";
            String[] whereArgs5 = { "Mesón 42" };
            db.update("donde_comer", santiago_comer_actualizado5, whereClause5, whereArgs5);

            ContentValues santiago_comer_actualizado6 = new ContentValues();
            santiago_comer_actualizado6.put("latitud", 42.8734967);
            santiago_comer_actualizado6.put("longitud", -8.545437999999999);
            String whereClause6 = "nombre_restaurante = ?";
            String[] whereArgs6 = { "O Tamboril" };
            db.update("donde_comer", santiago_comer_actualizado6, whereClause6, whereArgs6);

            ContentValues santiago_comer_actualizado7 = new ContentValues();
            santiago_comer_actualizado7.put("latitud", 42.8754437);
            santiago_comer_actualizado7.put("longitud", -8.5393105);
            String whereClause7 = "nombre_restaurante = ?";
            String[] whereArgs7 = { "O Sendeiro" };
            db.update("donde_comer", santiago_comer_actualizado7, whereClause7, whereArgs7);

            ContentValues santiago_comer_actualizado8 = new ContentValues();
            santiago_comer_actualizado8.put("latitud", 42.877867800000004);
            santiago_comer_actualizado8.put("longitud", -8.5441535);
            String whereClause8 = "nombre_restaurante = ?";
            String[] whereArgs8 = { "La Tita" };
            db.update("donde_comer", santiago_comer_actualizado8, whereClause8, whereArgs8);

            ContentValues vigo_comer_actualizado1 = new ContentValues();
            vigo_comer_actualizado1.put("latitud", 42.232754799999995);
            vigo_comer_actualizado1.put("longitud", -8.7160608);
            String whereClauseVi1 = "nombre_restaurante = ?";
            String[] whereArgsVi1 = { "Epoca Restaurante Peruano Fusión" };
            db.update("donde_comer", vigo_comer_actualizado1, whereClauseVi1, whereArgsVi1);

            ContentValues vigo_comer_actualizado2 = new ContentValues();
            vigo_comer_actualizado2.put("latitud", 42.2218691);
            vigo_comer_actualizado2.put("longitud", -8.7311097);
            String whereClauseVi2 = "nombre_restaurante = ?";
            String[] whereArgsVi2 = { "Os Padróns" };
            db.update("donde_comer", vigo_comer_actualizado2, whereClauseVi2, whereArgsVi2);

            ContentValues vigo_comer_actualizado3 = new ContentValues();
            vigo_comer_actualizado3.put("latitud", 42.2396653);
            vigo_comer_actualizado3.put("longitud", -8.7256688);
            String whereClauseVi3 = "nombre_restaurante = ?";
            String[] whereArgsVi3 = { "Restaurante Valdevez" };
            db.update("donde_comer", vigo_comer_actualizado3, whereClauseVi3, whereArgsVi3);

            ContentValues vigo_comer_actualizado4 = new ContentValues();
            vigo_comer_actualizado4.put("latitud", 42.23846470000001);
            vigo_comer_actualizado4.put("longitud", -8.724795);
            String whereClauseVi4 = "nombre_restaurante = ?";
            String[] whereArgsVi4 = { "Trepia gastronomía" };
            db.update("donde_comer", vigo_comer_actualizado4, whereClauseVi4, whereArgsVi4);

            ContentValues vigo_comer_actualizado5 = new ContentValues();
            vigo_comer_actualizado5.put("latitud", 42.2335364);
            vigo_comer_actualizado5.put("longitud", -8.7152678);
            String whereClauseVi5 = "nombre_restaurante = ?";
            String[] whereArgsVi5 = { "Nikko" };
            db.update("donde_comer", vigo_comer_actualizado5, whereClauseVi5, whereArgsVi5);

            ContentValues vigo_comer_actualizado6 = new ContentValues();
            vigo_comer_actualizado6.put("latitud", 42.2513377);
            vigo_comer_actualizado6.put("longitud", -8.6891891);
            String whereClauseVi6 = "nombre_restaurante = ?";
            String[] whereArgsVi6 = { "Casa Obdulia" };
            db.update("donde_comer", vigo_comer_actualizado6, whereClauseVi6, whereArgsVi6);

            ContentValues vigo_comer_actualizado7 = new ContentValues();
            vigo_comer_actualizado7.put("latitud", 42.2374174);
            vigo_comer_actualizado7.put("longitud", -8.716334699999999);
            String whereClauseVi7 = "nombre_restaurante = ?";
            String[] whereArgsVi7 = { "La pepita" };
            db.update("donde_comer", vigo_comer_actualizado7, whereClauseVi7, whereArgsVi7);

            ContentValues vigo_comer_actualizado8 = new ContentValues();
            vigo_comer_actualizado8.put("latitud", 42.2387538);
            vigo_comer_actualizado8.put("longitud", -8.7262807);
            String whereClauseVi8 = "nombre_restaurante = ?";
            String[] whereArgsVi8 = { "A pedra" };
            db.update("donde_comer", vigo_comer_actualizado8, whereClauseVi8, whereArgsVi8);



            ContentValues lugo_comer_actualizado1 = new ContentValues();
            lugo_comer_actualizado1.put("latitud", 43.0194206);
            lugo_comer_actualizado1.put("longitud", -7.558568899999999);
            String whereClauseLu1 = "nombre_restaurante = ?";
            String[] whereArgsLu1 = { "Bar Restaurante Parrilla Argentina Caminito" };
            db.update("donde_comer", lugo_comer_actualizado1, whereClauseLu1, whereArgsLu1);

            ContentValues lugo_comer_actualizado2 = new ContentValues();
            lugo_comer_actualizado2.put("latitud", 42.9948349);
            lugo_comer_actualizado2.put("longitud", -7.553145600000001);
            String whereClauseLu2 = "nombre_restaurante = ?";
            String[] whereArgsLu2 = { "La pizzeria di Totó" };
            db.update("donde_comer", lugo_comer_actualizado2, whereClauseLu2, whereArgsLu2);

            ContentValues lugo_comer_actualizado3 = new ContentValues();
            lugo_comer_actualizado3.put("latitud", 43.008004199999995);
            lugo_comer_actualizado3.put("longitud", -7.5601894);
            String whereClauseLu3 = "nombre_restaurante = ?";
            String[] whereArgsLu3 = { "Pasarela" };
            db.update("donde_comer", lugo_comer_actualizado3, whereClauseLu3, whereArgsLu3);

            ContentValues lugo_comer_actualizado4 = new ContentValues();
            lugo_comer_actualizado4.put("latitud", 43.007392499999995);
            lugo_comer_actualizado4.put("longitud", -7.5563978);
            String whereClauseLu4 = "nombre_restaurante = ?";
            String[] whereArgsLu4 = { "La Urbana" };
            db.update("donde_comer", lugo_comer_actualizado4, whereClauseLu4, whereArgsLu4);

            ContentValues lugo_comer_actualizado5 = new ContentValues();
            lugo_comer_actualizado5.put("latitud", 43.0047946);
            lugo_comer_actualizado5.put("longitud", -7.5590432000000005);
            String whereClauseLu5 = "nombre_restaurante = ?";
            String[] whereArgsLu5 = { "O Xugo" };
            db.update("donde_comer", lugo_comer_actualizado5, whereClauseLu5, whereArgsLu5);

            ContentValues lugo_comer_actualizado6 = new ContentValues();
            lugo_comer_actualizado6.put("latitud", 43.0107352);
            lugo_comer_actualizado6.put("longitud", -7.5589935);
            String whereClauseLu6 = "nombre_restaurante = ?";
            String[] whereArgsLu6 = { "Mesón da Rúa" };
            db.update("donde_comer", lugo_comer_actualizado6, whereClauseLu6, whereArgsLu6);

            ContentValues lugo_comer_actualizado7 = new ContentValues();
            lugo_comer_actualizado7.put("latitud", 43.010329399999996);
            lugo_comer_actualizado7.put("longitud", -7.5589249);
            String whereClauseLu7 = "nombre_restaurante = ?";
            String[] whereArgsLu7 = { "O tentaculo" };
            db.update("donde_comer", lugo_comer_actualizado7, whereClauseLu7, whereArgsLu7);

            ContentValues lugo_comer_actualizado8 = new ContentValues();
            lugo_comer_actualizado8.put("latitud", 43.010384599999995);
            lugo_comer_actualizado8.put("longitud", -7.5599300000000005);
            String whereClauseLu8 = "nombre_restaurante = ?";
            String[] whereArgsLu8 = { "Casa D Auga" };
            db.update("donde_comer", lugo_comer_actualizado8, whereClauseLu8, whereArgsLu8);

            ContentValues lugo_comer_actualizado9 = new ContentValues();
            lugo_comer_actualizado9.put("latitud", 43.01077140033981);
            lugo_comer_actualizado9.put("longitud", -7.553722126223843);
            String whereClauseLu9 = "nombre_restaurante = ?";
            String[] whereArgsLu9 = { "Restaurante Paprica" };
            db.update("donde_comer", lugo_comer_actualizado9, whereClauseLu9, whereArgsLu9);





            ContentValues pon_comer_actualizado1 = new ContentValues();
            pon_comer_actualizado1.put("latitud", 42.4090592);
            pon_comer_actualizado1.put("longitud", -8.754442400000002);
            String whereClausePon1 = "nombre_restaurante = ?";
            String[] whereArgsPon1 = { "Pepe Vieira" };
            db.update("donde_comer", pon_comer_actualizado1, whereClausePon1, whereArgsPon1);

            ContentValues pon_comer_actualizado2 = new ContentValues();
            pon_comer_actualizado2.put("latitud", 42.4333709);
            pon_comer_actualizado2.put("longitud", -8.669009899999999);
            String whereClausePon2 = "nombre_restaurante = ?";
            String[] whereArgsPon2 = { "Casa Solla" };
            db.update("donde_comer", pon_comer_actualizado2, whereClausePon2, whereArgsPon2);

            ContentValues pon_comer_actualizado3 = new ContentValues();
            pon_comer_actualizado3.put("latitud", 42.2403468);
            pon_comer_actualizado3.put("longitud", -8.723824);
            String whereClausePon3 = "nombre_restaurante = ?";
            String[] whereArgsPon3 = { "Maruja Limón" };
            db.update("donde_comer", pon_comer_actualizado3, whereClausePon3, whereArgsPon3);

            ContentValues pon_comer_actualizado4 = new ContentValues();
            pon_comer_actualizado4.put("latitud", 42.432601);
            pon_comer_actualizado4.put("longitud", -8.643374999999999);
            String whereClausePon4 = "nombre_restaurante = ?";
            String[] whereArgsPon4 = { "Eirado Da Leña" };
            db.update("donde_comer", pon_comer_actualizado4, whereClausePon4, whereArgsPon4);

            ContentValues pon_comer_actualizado5 = new ContentValues();
            pon_comer_actualizado5.put("latitud", 42.7940197);
            pon_comer_actualizado5.put("longitud", -8.2850416);
            String whereClausePon5 = "nombre_restaurante = ?";
            String[] whereArgsPon5 = { "O Pote" };
            db.update("donde_comer", pon_comer_actualizado5, whereClausePon5, whereArgsPon5);

            ContentValues pon_comer_actualizado6 = new ContentValues();
            pon_comer_actualizado6.put("latitud", 37.385171299999996);
            pon_comer_actualizado6.put("longitud", -5.9896825);
            String whereClausePon6 = "nombre_restaurante = ?";
            String[] whereArgsPon6 = { "Casa Román" };
            db.update("donde_comer", pon_comer_actualizado6, whereClausePon6, whereArgsPon6);

            ContentValues pon_comer_actualizado7 = new ContentValues();
            pon_comer_actualizado7.put("latitud", 42.4298846);
            pon_comer_actualizado7.put("longitud", -8.6446202);
            String whereClausePon7 = "nombre_restaurante = ?";
            String[] whereArgsPon7 = { "Don Alex" };
            db.update("donde_comer", pon_comer_actualizado7, whereClausePon7, whereArgsPon7);

            ContentValues pon_comer_actualizado8 = new ContentValues();
            pon_comer_actualizado8.put("latitud", 42.4301075);
            pon_comer_actualizado8.put("longitud", -8.6426283);
            String whereClausePon8 = "nombre_restaurante = ?";
            String[] whereArgsPon8 = { "Rías Baixas" };
            db.update("donde_comer", pon_comer_actualizado8, whereClausePon8, whereArgsPon8);

            ContentValues pon_comer_actualizado9 = new ContentValues();
            pon_comer_actualizado9.put("latitud", 42.4298846);
            pon_comer_actualizado9.put("longitud", -8.6446202);
            String whereClausePon9 = "nombre_restaurante = ?";
            String[] whereArgsPon9 = { "Casa Marco" };
            db.update("donde_comer", pon_comer_actualizado9, whereClausePon9, whereArgsPon9);




            ContentValues cor_comer_actualizado1 = new ContentValues();
            cor_comer_actualizado1.put("latitud", 43.3554202);
            cor_comer_actualizado1.put("longitud", -8.3990923);
            String whereClauseCor1 = "nombre_restaurante = ?";
            String[] whereArgsCor1 = { "Parrillada Milongas" };
            db.update("donde_comer", cor_comer_actualizado1, whereClauseCor1, whereArgsCor1);

            ContentValues cor_comer_actualizado2 = new ContentValues();
            cor_comer_actualizado2.put("latitud", 43.362343599999996);
            cor_comer_actualizado2.put("longitud", -8.4115401);
            String whereClauseCor2 = "nombre_restaurante = ?";
            String[] whereArgsCor2 = { "Alborada" };
            db.update("donde_comer", cor_comer_actualizado2, whereClauseCor2, whereArgsCor2);

            ContentValues cor_comer_actualizado3 = new ContentValues();
            cor_comer_actualizado3.put("latitud", 42.9234703);
            cor_comer_actualizado3.put("longitud", -9.2723785);
            String whereClauseCor3 = "nombre_restaurante = ?";
            String[] whereArgsCor3 = { "Taberna O Fragón" };
            db.update("donde_comer", cor_comer_actualizado3, whereClauseCor3, whereArgsCor3);

            ContentValues cor_comer_actualizado4 = new ContentValues();
            cor_comer_actualizado4.put("latitud", 43.3775025);
            cor_comer_actualizado4.put("longitud", -8.433088099999999);
            String whereClauseCor4 = "nombre_restaurante = ?";
            String[] whereArgsCor4 = { "Árbore da Veira" };
            db.update("donde_comer", cor_comer_actualizado4, whereClauseCor4, whereArgsCor4);

            ContentValues cor_comer_actualizado5 = new ContentValues();
            cor_comer_actualizado5.put("latitud", 43.3688429);
            cor_comer_actualizado5.put("longitud", -8.403396599999999);
            String whereClauseCor5 = "nombre_restaurante = ?";
            String[] whereArgsCor5 = { "O Lagar da Estrella" };
            db.update("donde_comer", cor_comer_actualizado5, whereClauseCor5, whereArgsCor5);

            ContentValues cor_comer_actualizado6 = new ContentValues();
            cor_comer_actualizado6.put("latitud", 43.3623043);
            cor_comer_actualizado6.put("longitud", -8.405805299999999);
            String whereClauseCor6 = "nombre_restaurante = ?";
            String[] whereArgsCor6 = { "Bido" };
            db.update("donde_comer", cor_comer_actualizado6, whereClauseCor6, whereArgsCor6);

            ContentValues cor_comer_actualizado7 = new ContentValues();
            cor_comer_actualizado7.put("latitud", 43.033457899999995);
            cor_comer_actualizado7.put("longitud", -8.8039045);
            String whereClauseCor7 = "nombre_restaurante = ?";
            String[] whereArgsCor7 = { "O Retiro da Costiña" };
            db.update("donde_comer", cor_comer_actualizado7, whereClauseCor7, whereArgsCor7);



            //LUGARES TURISTICOS SANTIAGO

            db.execSQL("ALTER TABLE lugares_interes ADD COLUMN latitud REAL");
            db.execSQL("ALTER TABLE lugares_interes ADD COLUMN longitud REAL");

            ContentValues santiago_lugar_actualizado1 = new ContentValues();
            santiago_lugar_actualizado1.put("latitud", 42.88059620000001);
            santiago_lugar_actualizado1.put("longitud", -8.5446412);
            String whereClauseSanlugar = "nombre = ?";
            String[] whereArgsSanlugar = { "Catedral de Santiago de Compostela" };
            db.update("lugares_interes", santiago_lugar_actualizado1, whereClauseSanlugar, whereArgsSanlugar);

            ContentValues santiago_lugar_actualizado2 = new ContentValues();
            santiago_lugar_actualizado2.put("latitud", 42.8802387900078);
            santiago_lugar_actualizado2.put("longitud", -8.54517327577852);
            String whereClauseSanlugar2 = "nombre = ?";
            String[] whereArgsSanlugar2 = { "Museo Catedralicio de Santiago de Compostela" };
            db.update("lugares_interes", santiago_lugar_actualizado2, whereClauseSanlugar2, whereArgsSanlugar2);

            ContentValues santiago_lugar_actualizado3 = new ContentValues();
            santiago_lugar_actualizado3.put("latitud", 42.87994639643054);
            santiago_lugar_actualizado3.put("longitud", -8.541304548506957);
            String whereClauseSanlugar3 = "nombre = ?";
            String[] whereArgsSanlugar3 = { "Mercado de Abastos en Santiago de Compostela" };
            db.update("lugares_interes", santiago_lugar_actualizado3, whereClauseSanlugar3, whereArgsSanlugar3);

            ContentValues santiago_lugar_actualizado4 = new ContentValues();
            santiago_lugar_actualizado4.put("latitud", 42.87940494206543);
            santiago_lugar_actualizado4.put("longitud", -8.545424008996873);
            String whereClauseSanlugar4 = "nombre = ?";
            String[] whereArgsSanlugar4 = { "Universidad de Santiago de Compostela (USC)" };
            db.update("lugares_interes", santiago_lugar_actualizado4, whereClauseSanlugar4, whereArgsSanlugar4);

            ContentValues santiago_lugar_actualizado5 = new ContentValues();
            santiago_lugar_actualizado5.put("latitud", 42.885563310475206);
            santiago_lugar_actualizado5.put("longitud", -8.500545428480157);
            String whereClauseSanlugar5 = "nombre = ?";
            String[] whereArgsSanlugar5 = { "Monte do Gozo" };
            db.update("lugares_interes", santiago_lugar_actualizado5, whereClauseSanlugar5, whereArgsSanlugar5);


            ContentValues santiago_lugar_actualizado6 = new ContentValues();
            santiago_lugar_actualizado6.put("latitud", 42.876944400076);
            santiago_lugar_actualizado6.put("longitud", -8.547607546240425);
            String whereClauseSanlugar6 = "nombre = ?";
            String[] whereArgsSanlugar6 = { "Parque de la Alameda" };
            db.update("lugares_interes", santiago_lugar_actualizado6, whereClauseSanlugar6, whereArgsSanlugar6);

            ContentValues santiago_lugar_actualizado7 = new ContentValues();
            santiago_lugar_actualizado7.put("latitud", 42.87728656992427);
            santiago_lugar_actualizado7.put("longitud", -8.538305265973658);
            String whereClauseSanlugar7 = "nombre = ?";
            String[] whereArgsSanlugar7 = { "Parque de Belvís" };
            db.update("lugares_interes", santiago_lugar_actualizado7, whereClauseSanlugar7, whereArgsSanlugar7);

            ContentValues santiago_lugar_actualizado8 = new ContentValues();
            santiago_lugar_actualizado8.put("latitud", 42.881370302162416);
            santiago_lugar_actualizado8.put("longitud", -8.544696603165823);
            String whereClauseSanlugar8 = "nombre = ?";
            String[] whereArgsSanlugar8 = { "Seminario Mayor" };
            db.update("lugares_interes", santiago_lugar_actualizado8, whereClauseSanlugar8, whereArgsSanlugar8);

            ContentValues santiago_lugar_actualizado9 = new ContentValues();
            santiago_lugar_actualizado9.put("latitud", 42.87670853890432);
            santiago_lugar_actualizado9.put("longitud", -8.536599920831852);
            String whereClauseSanlugar9 = "nombre = ?";
            String[] whereArgsSanlugar9 = { "Seminario Menor" };
            db.update("lugares_interes", santiago_lugar_actualizado9, whereClauseSanlugar9, whereArgsSanlugar9);

            ContentValues vigo_lugar_actualizado1 = new ContentValues();
            vigo_lugar_actualizado1.put("latitud", 42.236838678178465);
            vigo_lugar_actualizado1.put("longitud", -8.726632370025563);
            String whereClauseVilugar1 = "nombre = ?";
            String[] whereArgsVilugar1 = { "Castillo de San Sebastián en Vigo" };
            db.update("lugares_interes", vigo_lugar_actualizado1, whereClauseVilugar1, whereArgsVilugar1);

            ContentValues vigo_lugar_actualizado2 = new ContentValues();
            vigo_lugar_actualizado2.put("latitud", 42.23782606868535);
            vigo_lugar_actualizado2.put("longitud", -8.724901888492886);
            String whereClauseVilugar2 = "nombre = ?";
            String[] whereArgsVilugar2 = { "Sireno de Vigo y la Puerta del Sol" };
            db.update("lugares_interes", vigo_lugar_actualizado2, whereClauseVilugar2, whereArgsVilugar2);

            ContentValues vigo_lugar_actualizado3 = new ContentValues();
            vigo_lugar_actualizado3.put("latitud", 42.2393118091978);
            vigo_lugar_actualizado3.put("longitud", -8.726182829691792);
            String whereClauseVilugar3 = "nombre = ?";
            String[] whereArgsVilugar3 = { "Concatedral de Santa María de Vigo" };
            db.update("lugares_interes", vigo_lugar_actualizado3, whereClauseVilugar3, whereArgsVilugar3);

            ContentValues vigo_lugar_actualizado4 = new ContentValues();
            vigo_lugar_actualizado4.put("latitud", 42.23159782073613);
            vigo_lugar_actualizado4.put("longitud", -8.742376999827055);
            String whereClauseVilugar4 = "nombre = ?";
            String[] whereArgsVilugar4= { "El Puerto de Vigo" };
            db.update("lugares_interes", vigo_lugar_actualizado4, whereClauseVilugar4, whereArgsVilugar4);


            ContentValues vigo_lugar_actualizado5 = new ContentValues();
            vigo_lugar_actualizado5.put("latitud", 42.214554363679035);
            vigo_lugar_actualizado5.put("longitud", -8.905220655677322);
            String whereClauseVilugar5 = "nombre = ?";
            String[] whereArgsVilugar5 = { "Islas Cíes" };
            db.update("lugares_interes", vigo_lugar_actualizado5, whereClauseVilugar5, whereArgsVilugar5);

            ContentValues vigo_lugar_actualizado6 = new ContentValues();
            vigo_lugar_actualizado6.put("latitud", 42.2485737460864);
            vigo_lugar_actualizado6.put("longitud", -8.674961128471736);
            String whereClauseVilugar6 = "nombre = ?";
            String[] whereArgsVilugar6 = { "VigoZoo" };
            db.update("lugares_interes", vigo_lugar_actualizado6, whereClauseVilugar6, whereArgsVilugar6);

            ContentValues vigo_lugar_actualizado7 = new ContentValues();
            vigo_lugar_actualizado7.put("latitud", 42.208984619653705);
            vigo_lugar_actualizado7.put("longitud", -8.776518671778065);
            String whereClauseVilugar7 = "nombre = ?";
            String[] whereArgsVilugar7 = { "Playa de Samil" };
            db.update("lugares_interes", vigo_lugar_actualizado7, whereClauseVilugar7, whereArgsVilugar7);

            ContentValues vigo_lugar_actualizado8 = new ContentValues();
            vigo_lugar_actualizado8.put("latitud", 42.19829668316442);
            vigo_lugar_actualizado8.put("longitud", -8.79186837595486);
            String whereClauseVilugar8 = "nombre = ?";
            String[] whereArgsVilugar8 = { "Playa de O Vao" };
            db.update("lugares_interes", vigo_lugar_actualizado8, whereClauseVilugar8, whereArgsVilugar8);

            ContentValues vigo_lugar_actualizado9 = new ContentValues();
            vigo_lugar_actualizado9.put("latitud", 42.220225048014136);
            vigo_lugar_actualizado9.put("longitud", -8.77606468636274);
            String whereClauseVilugar9 = "nombre = ?";
            String[] whereArgsVilugar9 = { "Playa de Tombo do Gato" };
            db.update("lugares_interes", vigo_lugar_actualizado9, whereClauseVilugar9, whereArgsVilugar9);

            ContentValues lugo_lugar_actualizado1 = new ContentValues();
            lugo_lugar_actualizado1.put("latitud", 43.008834833373);
            lugo_lugar_actualizado1.put("longitud", -7.559199150042972);
            String whereClauseLulugar1 = "nombre = ?";
            String[] whereArgsLulugar1 = { "Muralla Romana de Lugo" };
            db.update("lugares_interes", lugo_lugar_actualizado1, whereClauseLulugar1, whereArgsLulugar1);

            ContentValues lugo_lugar_actualizado2 = new ContentValues();
            lugo_lugar_actualizado2.put("latitud", 43.00939340967838);
            lugo_lugar_actualizado2.put("longitud", -7.5576949861987295);
            String whereClauseLulugar2= "nombre = ?";
            String[] whereArgsLulugar2 = { "Catedral de Lugo" };
            db.update("lugares_interes", lugo_lugar_actualizado2, whereClauseLulugar2, whereArgsLulugar2);

            ContentValues lugo_lugar_actualizado3 = new ContentValues();
            lugo_lugar_actualizado3.put("latitud", 43.009577862797265);
            lugo_lugar_actualizado3.put("longitud", -7.557978622903867);
            String whereClauseLulugar3 = "nombre = ?";
            String[] whereArgsLulugar3 = { "Plaza de Santa María" };
            db.update("lugares_interes", lugo_lugar_actualizado3, whereClauseLulugar3, whereArgsLulugar3);

            ContentValues lugo_lugar_actualizado4 = new ContentValues();
            lugo_lugar_actualizado4.put("latitud", 43.009617124058686);
            lugo_lugar_actualizado4.put("longitud", -7.556879081728112);
            String whereClauseLulugar4 = "nombre = ?";
            String[] whereArgsLulugar4 = { "Plaza Mayor de Lugo" };
            db.update("lugares_interes", lugo_lugar_actualizado4, whereClauseLulugar4, whereArgsLulugar4);

            ContentValues lugo_lugar_actualizado5 = new ContentValues();
            lugo_lugar_actualizado5.put("latitud", 42.88454866735492);
            lugo_lugar_actualizado5.put("longitud", -7.527679837419753);
            String whereClauseLulugar5 = "nombre = ?";
            String[] whereArgsLulugar5 = { "Bosque da Fervenza en Lugo" };
            db.update("lugares_interes", lugo_lugar_actualizado5, whereClauseLulugar5, whereArgsLulugar5);

            ContentValues lugo_lugar_actualizado6 = new ContentValues();
            lugo_lugar_actualizado6.put("latitud", 43.55405794906853);
            lugo_lugar_actualizado6.put("longitud", -7.1572276777182156);
            String whereClauseLulugar6 = "nombre = ?";
            String[] whereArgsLulugar6 = { "Playa de las Catedrales" };
            db.update("lugares_interes", lugo_lugar_actualizado6, whereClauseLulugar6, whereArgsLulugar6);

            ContentValues lugo_lugar_actualizado7 = new ContentValues();
            lugo_lugar_actualizado7.put("latitud", 43.01054709834349);
            lugo_lugar_actualizado7.put("longitud", -7.557098826060633);
            String whereClauseLulugar7 = "nombre = ?";
            String[] whereArgsLulugar7 = { "Casa dos Mosaicos" };
            db.update("lugares_interes", lugo_lugar_actualizado7, whereClauseLulugar7, whereArgsLulugar7);

            ContentValues lugo_lugar_actualizado8 = new ContentValues();
            lugo_lugar_actualizado8.put("latitud", 43.00915153883344);
            lugo_lugar_actualizado8.put("longitud", -7.5591586726955144);
            String whereClauseLulugar8 = "nombre = ?";
            String[] whereArgsLulugar8 = { "Museo Universitario «A Domus do Mitreo»" };
            db.update("lugares_interes", lugo_lugar_actualizado8, whereClauseLulugar8, whereArgsLulugar8);

            ContentValues lugo_lugar_actualizado9 = new ContentValues();
            lugo_lugar_actualizado9.put("latitud", 42.411036490601234);
            lugo_lugar_actualizado9.put("longitud", -7.632368889799922);
            String whereClauseLulugar9 = "nombre = ?";
            String[] whereArgsLulugar9 = { "Cañón y riberas del Sil" };
            db.update("lugares_interes", lugo_lugar_actualizado9, whereClauseLulugar9, whereArgsLulugar9);

            ContentValues pontevedra_lugar_actualizado1 = new ContentValues();
            pontevedra_lugar_actualizado1.put("latitud", 42.43078761366287);
            pontevedra_lugar_actualizado1.put("longitud", -8.643619555740408);
            String whereClausePonlugar1 = "nombre = ?";
            String[] whereArgsPonlugar1 = { "Santuario de la Virgen Peregrina" };
            db.update("lugares_interes", pontevedra_lugar_actualizado1, whereClausePonlugar1, whereArgsPonlugar1);

            ContentValues pontevedra_lugar_actualizado2 = new ContentValues();
            pontevedra_lugar_actualizado2.put("latitud", 42.431472724475626);
            pontevedra_lugar_actualizado2.put("longitud", -8.644219663589201);
            String whereClausePonlugar2 = "nombre = ?";
            String[] whereArgsPonlugar2 = { "Plaza de la Herrería" };
            db.update("lugares_interes", pontevedra_lugar_actualizado1, whereClausePonlugar2, whereArgsPonlugar2);

            ContentValues pontevedra_lugar_actualizado3 = new ContentValues();
            pontevedra_lugar_actualizado3.put("latitud", 42.43379858787328);
            pontevedra_lugar_actualizado3.put("longitud", -8.647464966493494);
            String whereClausePonlugar3 = "nombre = ?";
            String[] whereArgsPonlugar3 = { "Basílica de Santa María la Mayor" };
            db.update("lugares_interes", pontevedra_lugar_actualizado3, whereClausePonlugar3, whereArgsPonlugar3);

            ContentValues pontevedra_lugar_actualizado4 = new ContentValues();
            pontevedra_lugar_actualizado4.put("latitud", 42.43134758666411);
            pontevedra_lugar_actualizado4.put("longitud", -8.64704664327675);
            String whereClausePonlugar4 = "nombre = ?";
            String[] whereArgsPonlugar4 = { "Ruinas de Santo Domingo" };
            db.update("lugares_interes", pontevedra_lugar_actualizado4, whereClausePonlugar4, whereArgsPonlugar4);

            ContentValues pontevedra_lugar_actualizado5 = new ContentValues();
            pontevedra_lugar_actualizado5.put("latitud", 42.43134758666411);
            pontevedra_lugar_actualizado5.put("longitud", -8.64704664327675);
            String whereClausePonlugar5 = "nombre = ?";
            String[] whereArgsPonlugar5 = { "Playa de Castiñeiras" };
            db.update("lugares_interes", pontevedra_lugar_actualizado5, whereClausePonlugar5, whereArgsPonlugar5);

            ContentValues pontevedra_lugar_actualizado6 = new ContentValues();
            pontevedra_lugar_actualizado6.put("latitud", 42.431365775388294);
            pontevedra_lugar_actualizado6.put("longitud", -8.643311119065995);
            String whereClausePonlugar6 = "nombre = ?";
            String[] whereArgsPonlugar6 = { "Convento de San Francisco" };
            db.update("lugares_interes", pontevedra_lugar_actualizado6, whereClausePonlugar6, whereArgsPonlugar6);

            ContentValues pontevedra_lugar_actualizado7 = new ContentValues();
            pontevedra_lugar_actualizado7.put("latitud", 42.463825967269564);
            pontevedra_lugar_actualizado7.put("longitud", -8.94335266812085);
            String whereClausePonlugar7 = "nombre = ?";
            String[] whereArgsPonlugar7 = { "Con Negro" };
            db.update("lugares_interes", pontevedra_lugar_actualizado7, whereClausePonlugar7, whereArgsPonlugar7);

            ContentValues pontevedra_lugar_actualizado8 = new ContentValues();
            pontevedra_lugar_actualizado8.put("latitud", 42.43354727974957);
            pontevedra_lugar_actualizado8.put("longitud", -8.641947513080586);
            String whereClausePonlugar8 = "nombre = ?";
            String[] whereArgsPonlugar8 = { "Edificio Castelao" };
            db.update("lugares_interes", pontevedra_lugar_actualizado8, whereClausePonlugar8, whereArgsPonlugar8);

            ContentValues a_corunha_lugar_actualizado1 = new ContentValues();
            a_corunha_lugar_actualizado1.put("latitud", 43.385932055874605);
            a_corunha_lugar_actualizado1.put("longitud", -8.406567661342157);
            String whereClauseColugar1 = "nombre = ?";
            String[] whereArgsColugar1 = { "Torre de Hércules" };
            db.update("lugares_interes", a_corunha_lugar_actualizado1, whereClauseColugar1, whereArgsColugar1);

            ContentValues a_corunha_lugar_actualizado2 = new ContentValues();
            a_corunha_lugar_actualizado2.put("latitud", 43.36210168405226);
            a_corunha_lugar_actualizado2.put("longitud", -8.412573566795256);
            String whereClauseColugar2 = "nombre = ?";
            String[] whereArgsColugar2 = { "Casa de las Ciencias en A Coruña" };
            db.update("lugares_interes", a_corunha_lugar_actualizado2, whereClauseColugar2, whereArgsColugar2);

            ContentValues a_corunha_lugar_actualizado3 = new ContentValues();
            a_corunha_lugar_actualizado3.put("latitud", 43.3835985835451);
            a_corunha_lugar_actualizado3.put("longitud", -8.409604932779807);
            String whereClauseColugar3 = "nombre = ?";
            String[] whereArgsColugar3 = { "Aquarium Finisterrae" };
            db.update("lugares_interes", a_corunha_lugar_actualizado3, whereClauseColugar3, whereArgsColugar3);

            ContentValues a_corunha_lugar_actualizado4 = new ContentValues();
            a_corunha_lugar_actualizado4.put("latitud", 43.3777818369346);
            a_corunha_lugar_actualizado4.put("longitud", -8.406645009523203);
            String whereClauseColugar4 = "nombre = ?";
            String[] whereArgsColugar4 = { "Domus-Casa del Hombre en A Coruña" };
            db.update("lugares_interes", a_corunha_lugar_actualizado4, whereClauseColugar4, whereArgsColugar4);

            ContentValues a_corunha_lugar_actualizado5 = new ContentValues();
            a_corunha_lugar_actualizado5.put("latitud", 43.365749439777595);
            a_corunha_lugar_actualizado5.put("longitud", -8.387784163070464);
            String whereClauseColugar5 = "nombre = ?";
            String[] whereArgsColugar5 = { "El Castillo de Santo Antón" };
            db.update("lugares_interes", a_corunha_lugar_actualizado5, whereClauseColugar5, whereArgsColugar5);

            ContentValues a_corunha_lugar_actualizado6 = new ContentValues();
            a_corunha_lugar_actualizado6.put("latitud", 43.371183551941705);
            a_corunha_lugar_actualizado6.put("longitud", -8.39639244240281);
            String whereClauseColugar6 = "nombre = ?";
            String[] whereArgsColugar6 = { "Plaza de María Pita" };
            db.update("lugares_interes", a_corunha_lugar_actualizado6, whereClauseColugar6, whereArgsColugar6);


            ContentValues a_corunha_lugar_actualizado7 = new ContentValues();
            a_corunha_lugar_actualizado7.put("latitud", 43.36874754932928);
            a_corunha_lugar_actualizado7.put("longitud", -8.41139718770007);
            String whereClauseColugar7 = "nombre = ?";
            String[] whereArgsColugar7 = { "Playa de Riazor" };
            db.update("lugares_interes", a_corunha_lugar_actualizado7, whereClauseColugar7, whereArgsColugar7);

            ContentValues a_corunha_lugar_actualizado8 = new ContentValues();
            a_corunha_lugar_actualizado8.put("latitud", 43.37736215117283);
            a_corunha_lugar_actualizado8.put("longitud", -8.43667614778045);
            String whereClauseColugar8 = "nombre = ?";
            String[] whereArgsColugar8 = { "Monte de San Pedro" };
            db.update("lugares_interes", a_corunha_lugar_actualizado8, whereClauseColugar8, whereArgsColugar8);






        }
    }
    public SQLiteDatabase abreBD() {
        if (db==null) {
            db = getWritableDatabase();
        }
        return db;
    }


    public void cierraBD() {
        if (db!=null) {
            db.close();
            db=null;
        }
    }

}
