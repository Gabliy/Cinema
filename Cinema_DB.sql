PGDMP                         w            Cinema    12.1    12.1 E    `           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            a           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            b           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            c           1262    16393    Cinema    DATABASE     �   CREATE DATABASE "Cinema" WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'English_United States.1252' LC_CTYPE = 'English_United States.1252';
    DROP DATABASE "Cinema";
                postgres    false            �            1259    19353    cinemas    TABLE     �   CREATE TABLE public.cinemas (
    idcinema integer NOT NULL,
    capacidade integer NOT NULL,
    localizacao character varying(255) NOT NULL
);
    DROP TABLE public.cinemas;
       public         heap    postgres    false            �            1259    19351    cinemas_idcinema_seq    SEQUENCE     �   CREATE SEQUENCE public.cinemas_idcinema_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.cinemas_idcinema_seq;
       public          postgres    false    203            d           0    0    cinemas_idcinema_seq    SEQUENCE OWNED BY     M   ALTER SEQUENCE public.cinemas_idcinema_seq OWNED BY public.cinemas.idcinema;
          public          postgres    false    202            �            1259    19422    clientes    TABLE     �   CREATE TABLE public.clientes (
    idcliente integer NOT NULL,
    nome character varying(255) NOT NULL,
    endereco character varying(255) NOT NULL,
    telefone character varying(255) NOT NULL,
    cpf character varying(255)
);
    DROP TABLE public.clientes;
       public         heap    postgres    false            �            1259    19420    clientes_idcliente_seq    SEQUENCE     �   CREATE SEQUENCE public.clientes_idcliente_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public.clientes_idcliente_seq;
       public          postgres    false    213            e           0    0    clientes_idcliente_seq    SEQUENCE OWNED BY     Q   ALTER SEQUENCE public.clientes_idcliente_seq OWNED BY public.clientes.idcliente;
          public          postgres    false    212            �            1259    19374    filmes    TABLE     �   CREATE TABLE public.filmes (
    idfilme integer NOT NULL,
    titulo character varying(255) NOT NULL,
    refe character varying(255) NOT NULL,
    duracao character varying(255)
);
    DROP TABLE public.filmes;
       public         heap    postgres    false            �            1259    19372    filmes_idfilme_seq    SEQUENCE     �   CREATE SEQUENCE public.filmes_idfilme_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.filmes_idfilme_seq;
       public          postgres    false    207            f           0    0    filmes_idfilme_seq    SEQUENCE OWNED BY     I   ALTER SEQUENCE public.filmes_idfilme_seq OWNED BY public.filmes.idfilme;
          public          postgres    false    206            �            1259    19406    funcionarios    TABLE     �   CREATE TABLE public.funcionarios (
    idfunc integer NOT NULL,
    nome character varying(255) NOT NULL,
    endereco character varying(255) NOT NULL,
    telefone character varying(255) NOT NULL,
    idcinema_fk integer
);
     DROP TABLE public.funcionarios;
       public         heap    postgres    false            �            1259    19404    funcionarios_idfunc_seq    SEQUENCE     �   CREATE SEQUENCE public.funcionarios_idfunc_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 .   DROP SEQUENCE public.funcionarios_idfunc_seq;
       public          postgres    false    211            g           0    0    funcionarios_idfunc_seq    SEQUENCE OWNED BY     S   ALTER SEQUENCE public.funcionarios_idfunc_seq OWNED BY public.funcionarios.idfunc;
          public          postgres    false    210            �            1259    19433 	   ingressos    TABLE     �  CREATE TABLE public.ingressos (
    idingresso integer NOT NULL,
    preco double precision NOT NULL,
    estudante boolean NOT NULL,
    colfil character varying(255) NOT NULL,
    filme character varying(255) NOT NULL,
    sessao character varying(255) NOT NULL,
    ingressodata character varying(255) NOT NULL,
    compradata character varying(255) NOT NULL,
    idcliente_fk integer,
    idfunc_fk integer,
    qtdingresso integer,
    numsala integer NOT NULL,
    pagamento character varying(255)
);
    DROP TABLE public.ingressos;
       public         heap    postgres    false            �            1259    19431    ingressos_idingresso_seq    SEQUENCE     �   CREATE SEQUENCE public.ingressos_idingresso_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 /   DROP SEQUENCE public.ingressos_idingresso_seq;
       public          postgres    false    215            h           0    0    ingressos_idingresso_seq    SEQUENCE OWNED BY     U   ALTER SEQUENCE public.ingressos_idingresso_seq OWNED BY public.ingressos.idingresso;
          public          postgres    false    214            �            1259    19361    salas    TABLE     �   CREATE TABLE public.salas (
    idsala integer NOT NULL,
    numsala integer NOT NULL,
    qtdcadeira integer NOT NULL,
    idcinema_fk integer
);
    DROP TABLE public.salas;
       public         heap    postgres    false            �            1259    19359    salas_idsala_seq    SEQUENCE     �   CREATE SEQUENCE public.salas_idsala_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.salas_idsala_seq;
       public          postgres    false    205            i           0    0    salas_idsala_seq    SEQUENCE OWNED BY     E   ALTER SEQUENCE public.salas_idsala_seq OWNED BY public.salas.idsala;
          public          postgres    false    204            �            1259    19385    sessaos    TABLE     8  CREATE TABLE public.sessaos (
    idsessao integer NOT NULL,
    preco double precision NOT NULL,
    horario character varying(255) NOT NULL,
    nome_filme character varying(255) NOT NULL,
    numsala integer NOT NULL,
    data character varying(255) NOT NULL,
    idfilme_fk integer,
    idsala_fk integer
);
    DROP TABLE public.sessaos;
       public         heap    postgres    false            �            1259    19383    sessaos_idsessao_seq    SEQUENCE     �   CREATE SEQUENCE public.sessaos_idsessao_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.sessaos_idsessao_seq;
       public          postgres    false    209            j           0    0    sessaos_idsessao_seq    SEQUENCE OWNED BY     M   ALTER SEQUENCE public.sessaos_idsessao_seq OWNED BY public.sessaos.idsessao;
          public          postgres    false    208            �            1259    19454    vendas    TABLE     0  CREATE TABLE public.vendas (
    idvenda integer NOT NULL,
    preco double precision NOT NULL,
    estudante boolean NOT NULL,
    ingressodata character varying(255) NOT NULL,
    compradata character varying(255) NOT NULL,
    idcliente_fk integer,
    idfunc_fk integer,
    idingresso_fk integer
);
    DROP TABLE public.vendas;
       public         heap    postgres    false            �            1259    19452    vendas_idvenda_seq    SEQUENCE     �   CREATE SEQUENCE public.vendas_idvenda_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.vendas_idvenda_seq;
       public          postgres    false    217            k           0    0    vendas_idvenda_seq    SEQUENCE OWNED BY     I   ALTER SEQUENCE public.vendas_idvenda_seq OWNED BY public.vendas.idvenda;
          public          postgres    false    216            �
           2604    19356    cinemas idcinema    DEFAULT     t   ALTER TABLE ONLY public.cinemas ALTER COLUMN idcinema SET DEFAULT nextval('public.cinemas_idcinema_seq'::regclass);
 ?   ALTER TABLE public.cinemas ALTER COLUMN idcinema DROP DEFAULT;
       public          postgres    false    202    203    203            �
           2604    19425    clientes idcliente    DEFAULT     x   ALTER TABLE ONLY public.clientes ALTER COLUMN idcliente SET DEFAULT nextval('public.clientes_idcliente_seq'::regclass);
 A   ALTER TABLE public.clientes ALTER COLUMN idcliente DROP DEFAULT;
       public          postgres    false    213    212    213            �
           2604    19377    filmes idfilme    DEFAULT     p   ALTER TABLE ONLY public.filmes ALTER COLUMN idfilme SET DEFAULT nextval('public.filmes_idfilme_seq'::regclass);
 =   ALTER TABLE public.filmes ALTER COLUMN idfilme DROP DEFAULT;
       public          postgres    false    207    206    207            �
           2604    19409    funcionarios idfunc    DEFAULT     z   ALTER TABLE ONLY public.funcionarios ALTER COLUMN idfunc SET DEFAULT nextval('public.funcionarios_idfunc_seq'::regclass);
 B   ALTER TABLE public.funcionarios ALTER COLUMN idfunc DROP DEFAULT;
       public          postgres    false    211    210    211            �
           2604    19436    ingressos idingresso    DEFAULT     |   ALTER TABLE ONLY public.ingressos ALTER COLUMN idingresso SET DEFAULT nextval('public.ingressos_idingresso_seq'::regclass);
 C   ALTER TABLE public.ingressos ALTER COLUMN idingresso DROP DEFAULT;
       public          postgres    false    214    215    215            �
           2604    19364    salas idsala    DEFAULT     l   ALTER TABLE ONLY public.salas ALTER COLUMN idsala SET DEFAULT nextval('public.salas_idsala_seq'::regclass);
 ;   ALTER TABLE public.salas ALTER COLUMN idsala DROP DEFAULT;
       public          postgres    false    205    204    205            �
           2604    19388    sessaos idsessao    DEFAULT     t   ALTER TABLE ONLY public.sessaos ALTER COLUMN idsessao SET DEFAULT nextval('public.sessaos_idsessao_seq'::regclass);
 ?   ALTER TABLE public.sessaos ALTER COLUMN idsessao DROP DEFAULT;
       public          postgres    false    208    209    209            �
           2604    19457    vendas idvenda    DEFAULT     p   ALTER TABLE ONLY public.vendas ALTER COLUMN idvenda SET DEFAULT nextval('public.vendas_idvenda_seq'::regclass);
 =   ALTER TABLE public.vendas ALTER COLUMN idvenda DROP DEFAULT;
       public          postgres    false    216    217    217            O          0    19353    cinemas 
   TABLE DATA           D   COPY public.cinemas (idcinema, capacidade, localizacao) FROM stdin;
    public          postgres    false    203   �R       Y          0    19422    clientes 
   TABLE DATA           L   COPY public.clientes (idcliente, nome, endereco, telefone, cpf) FROM stdin;
    public          postgres    false    213   �R       S          0    19374    filmes 
   TABLE DATA           @   COPY public.filmes (idfilme, titulo, refe, duracao) FROM stdin;
    public          postgres    false    207   @S       W          0    19406    funcionarios 
   TABLE DATA           U   COPY public.funcionarios (idfunc, nome, endereco, telefone, idcinema_fk) FROM stdin;
    public          postgres    false    211   �S       [          0    19433 	   ingressos 
   TABLE DATA           �   COPY public.ingressos (idingresso, preco, estudante, colfil, filme, sessao, ingressodata, compradata, idcliente_fk, idfunc_fk, qtdingresso, numsala, pagamento) FROM stdin;
    public          postgres    false    215   &T       Q          0    19361    salas 
   TABLE DATA           I   COPY public.salas (idsala, numsala, qtdcadeira, idcinema_fk) FROM stdin;
    public          postgres    false    205   U       U          0    19385    sessaos 
   TABLE DATA           m   COPY public.sessaos (idsessao, preco, horario, nome_filme, numsala, data, idfilme_fk, idsala_fk) FROM stdin;
    public          postgres    false    209   7U       ]          0    19454    vendas 
   TABLE DATA           }   COPY public.vendas (idvenda, preco, estudante, ingressodata, compradata, idcliente_fk, idfunc_fk, idingresso_fk) FROM stdin;
    public          postgres    false    217   �U       l           0    0    cinemas_idcinema_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.cinemas_idcinema_seq', 1, false);
          public          postgres    false    202            m           0    0    clientes_idcliente_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('public.clientes_idcliente_seq', 2, true);
          public          postgres    false    212            n           0    0    filmes_idfilme_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public.filmes_idfilme_seq', 5, true);
          public          postgres    false    206            o           0    0    funcionarios_idfunc_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('public.funcionarios_idfunc_seq', 2, true);
          public          postgres    false    210            p           0    0    ingressos_idingresso_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public.ingressos_idingresso_seq', 8, true);
          public          postgres    false    214            q           0    0    salas_idsala_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.salas_idsala_seq', 1, false);
          public          postgres    false    204            r           0    0    sessaos_idsessao_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.sessaos_idsessao_seq', 4, true);
          public          postgres    false    208            s           0    0    vendas_idvenda_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public.vendas_idvenda_seq', 1, false);
          public          postgres    false    216            �
           2606    19358    cinemas cinemas_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public.cinemas
    ADD CONSTRAINT cinemas_pkey PRIMARY KEY (idcinema);
 >   ALTER TABLE ONLY public.cinemas DROP CONSTRAINT cinemas_pkey;
       public            postgres    false    203            �
           2606    19430    clientes clientes_pkey 
   CONSTRAINT     [   ALTER TABLE ONLY public.clientes
    ADD CONSTRAINT clientes_pkey PRIMARY KEY (idcliente);
 @   ALTER TABLE ONLY public.clientes DROP CONSTRAINT clientes_pkey;
       public            postgres    false    213            �
           2606    19382    filmes filmes_pkey 
   CONSTRAINT     U   ALTER TABLE ONLY public.filmes
    ADD CONSTRAINT filmes_pkey PRIMARY KEY (idfilme);
 <   ALTER TABLE ONLY public.filmes DROP CONSTRAINT filmes_pkey;
       public            postgres    false    207            �
           2606    19414    funcionarios funcionarios_pkey 
   CONSTRAINT     `   ALTER TABLE ONLY public.funcionarios
    ADD CONSTRAINT funcionarios_pkey PRIMARY KEY (idfunc);
 H   ALTER TABLE ONLY public.funcionarios DROP CONSTRAINT funcionarios_pkey;
       public            postgres    false    211            �
           2606    19441    ingressos ingressos_pkey 
   CONSTRAINT     ^   ALTER TABLE ONLY public.ingressos
    ADD CONSTRAINT ingressos_pkey PRIMARY KEY (idingresso);
 B   ALTER TABLE ONLY public.ingressos DROP CONSTRAINT ingressos_pkey;
       public            postgres    false    215            �
           2606    19366    salas salas_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.salas
    ADD CONSTRAINT salas_pkey PRIMARY KEY (idsala);
 :   ALTER TABLE ONLY public.salas DROP CONSTRAINT salas_pkey;
       public            postgres    false    205            �
           2606    19393    sessaos sessaos_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public.sessaos
    ADD CONSTRAINT sessaos_pkey PRIMARY KEY (idsessao);
 >   ALTER TABLE ONLY public.sessaos DROP CONSTRAINT sessaos_pkey;
       public            postgres    false    209            �
           2606    19462    vendas vendas_pkey 
   CONSTRAINT     U   ALTER TABLE ONLY public.vendas
    ADD CONSTRAINT vendas_pkey PRIMARY KEY (idvenda);
 <   ALTER TABLE ONLY public.vendas DROP CONSTRAINT vendas_pkey;
       public            postgres    false    217            �
           2606    19415 *   funcionarios funcionarios_idcinema_fk_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.funcionarios
    ADD CONSTRAINT funcionarios_idcinema_fk_fkey FOREIGN KEY (idcinema_fk) REFERENCES public.cinemas(idcinema);
 T   ALTER TABLE ONLY public.funcionarios DROP CONSTRAINT funcionarios_idcinema_fk_fkey;
       public          postgres    false    211    203    2744            �
           2606    19442 %   ingressos ingressos_idcliente_fk_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.ingressos
    ADD CONSTRAINT ingressos_idcliente_fk_fkey FOREIGN KEY (idcliente_fk) REFERENCES public.clientes(idcliente);
 O   ALTER TABLE ONLY public.ingressos DROP CONSTRAINT ingressos_idcliente_fk_fkey;
       public          postgres    false    215    2754    213            �
           2606    19447 "   ingressos ingressos_idfunc_fk_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.ingressos
    ADD CONSTRAINT ingressos_idfunc_fk_fkey FOREIGN KEY (idfunc_fk) REFERENCES public.funcionarios(idfunc);
 L   ALTER TABLE ONLY public.ingressos DROP CONSTRAINT ingressos_idfunc_fk_fkey;
       public          postgres    false    211    215    2752            �
           2606    19367    salas salas_idcinema_fk_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.salas
    ADD CONSTRAINT salas_idcinema_fk_fkey FOREIGN KEY (idcinema_fk) REFERENCES public.cinemas(idcinema);
 F   ALTER TABLE ONLY public.salas DROP CONSTRAINT salas_idcinema_fk_fkey;
       public          postgres    false    2744    203    205            �
           2606    19399    sessaos sessaos_idfilme_fk_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.sessaos
    ADD CONSTRAINT sessaos_idfilme_fk_fkey FOREIGN KEY (idfilme_fk) REFERENCES public.filmes(idfilme);
 I   ALTER TABLE ONLY public.sessaos DROP CONSTRAINT sessaos_idfilme_fk_fkey;
       public          postgres    false    207    2748    209            �
           2606    19394    sessaos sessaos_idsala_fk_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.sessaos
    ADD CONSTRAINT sessaos_idsala_fk_fkey FOREIGN KEY (idsala_fk) REFERENCES public.salas(idsala);
 H   ALTER TABLE ONLY public.sessaos DROP CONSTRAINT sessaos_idsala_fk_fkey;
       public          postgres    false    205    2746    209            �
           2606    19463    vendas vendas_idcliente_fk_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.vendas
    ADD CONSTRAINT vendas_idcliente_fk_fkey FOREIGN KEY (idcliente_fk) REFERENCES public.clientes(idcliente);
 I   ALTER TABLE ONLY public.vendas DROP CONSTRAINT vendas_idcliente_fk_fkey;
       public          postgres    false    213    217    2754            �
           2606    19468    vendas vendas_idfunc_fk_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.vendas
    ADD CONSTRAINT vendas_idfunc_fk_fkey FOREIGN KEY (idfunc_fk) REFERENCES public.funcionarios(idfunc);
 F   ALTER TABLE ONLY public.vendas DROP CONSTRAINT vendas_idfunc_fk_fkey;
       public          postgres    false    217    2752    211            �
           2606    19473     vendas vendas_idingresso_fk_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.vendas
    ADD CONSTRAINT vendas_idingresso_fk_fkey FOREIGN KEY (idingresso_fk) REFERENCES public.ingressos(idingresso);
 J   ALTER TABLE ONLY public.vendas DROP CONSTRAINT vendas_idingresso_fk_fkey;
       public          postgres    false    217    215    2756            O      x������ � �      Y   E   x�3���O��JMN�+��43��426513��407�4�06740�2�(K+�JI��4 K��(����� <      S   �   x�U�K
1�u�����]�\��;7E1B2�3sC:�.�xT�D� ����ڼ��	� ��7�5ѿ��󨃏�@�X���,�'��"�H��>:�2rT1�BNt�e7n��ʐ�o�Gg�����Z]j�,��<z��V�F�      W   <   x�3���O��,JMN�+��4�07��4���2�d�%�$�!d-��MM,-@
b���� Lb�      [   �   x�}�A�� E���@ې���6]�l�Qf�MR��h�2+Ѧ�(�d/���;��;l����Ώ�v���;�=��T,�7`�bέ�ꑸ��|CbԈ�X�!���&E��IiK�JY��!.[8Ż*֪Zh�0�?�-�����jpR��{�t�[7�}�b.M�r!~��k����\��w����lae��G,p\�!
����Sь��,`RB)0�7�< Q�l�      Q      x������ � �      U   �   x�e�1�0Eg�9��"�l������ҡ)r��1�����M@#��p�t��@ x`����q�.	��V�O}��/�����xYEM�xPCWC:ۀh.Z��?9v2�^�6+�{Qi@�����7+�      ]      x������ � �     