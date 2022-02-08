PGDMP     8    #                z            VetApp    14.1    14.1 :    ;           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            <           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            =           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            >           1262    16394    VetApp    DATABASE     e   CREATE DATABASE "VetApp" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Turkish_Turkey.1254';
    DROP DATABASE "VetApp";
                postgres    false            �            1259    16693    animaltypes    TABLE     a   CREATE TABLE public.animaltypes (
    id integer NOT NULL,
    typename character varying(50)
);
    DROP TABLE public.animaltypes;
       public         heap    postgres    false            �            1259    16692    animaltypes_id_seq    SEQUENCE     �   ALTER TABLE public.animaltypes ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.animaltypes_id_seq
    START WITH 10001
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    224            �            1259    16551    informations    TABLE     �   CREATE TABLE public.informations (
    id integer NOT NULL,
    email character varying(255),
    telephone character varying(20),
    address character(255)
);
     DROP TABLE public.informations;
       public         heap    postgres    false            �            1259    16550    informations_id_seq    SEQUENCE     �   ALTER TABLE public.informations ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.informations_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    216            �            1259    16593    pets    TABLE     �   CREATE TABLE public.pets (
    id integer NOT NULL,
    petname character varying(20),
    petage character varying(3),
    petdescription character varying(255),
    petbreed character varying(50),
    typeid integer
);
    DROP TABLE public.pets;
       public         heap    postgres    false            �            1259    16592    pets_id_seq    SEQUENCE     �   ALTER TABLE public.pets ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.pets_id_seq
    START WITH 32000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    220            �            1259    16469    roles    TABLE     �   CREATE TABLE public.roles (
    id smallint NOT NULL,
    rolename character varying(20),
    authority character varying(20)
);
    DROP TABLE public.roles;
       public         heap    postgres    false            �            1259    16468    roles_id_seq    SEQUENCE     �   ALTER TABLE public.roles ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.roles_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    212            �            1259    16559    user_informations    TABLE     r   CREATE TABLE public.user_informations (
    id integer NOT NULL,
    userid integer,
    informationid integer
);
 %   DROP TABLE public.user_informations;
       public         heap    postgres    false            �            1259    16577    user_informations_id_seq    SEQUENCE     �   ALTER TABLE public.user_informations ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.user_informations_id_seq
    START WITH 1000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    217            �            1259    16634 	   user_pets    TABLE     b   CREATE TABLE public.user_pets (
    id integer NOT NULL,
    userid integer,
    petid integer
);
    DROP TABLE public.user_pets;
       public         heap    postgres    false            �            1259    16633    user_pets_id_seq    SEQUENCE     �   ALTER TABLE public.user_pets ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.user_pets_id_seq
    START WITH 5001
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    222            �            1259    16480 
   user_roles    TABLE     e   CREATE TABLE public.user_roles (
    id integer NOT NULL,
    userid integer,
    roleid smallint
);
    DROP TABLE public.user_roles;
       public         heap    postgres    false            �            1259    16479    user_roles_id_seq    SEQUENCE     �   ALTER TABLE public.user_roles ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.user_roles_id_seq
    START WITH 100
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    214            �            1259    16455    users    TABLE     �   CREATE TABLE public.users (
    id integer NOT NULL,
    username character varying(20),
    password character varying(255),
    firstname character varying(20),
    lastname character varying(20)
);
    DROP TABLE public.users;
       public         heap    postgres    false            �            1259    16454    users_id_seq    SEQUENCE     �   ALTER TABLE public.users ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.users_id_seq
    START WITH 78
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    210            8          0    16693    animaltypes 
   TABLE DATA           3   COPY public.animaltypes (id, typename) FROM stdin;
    public          postgres    false    224   �?       0          0    16551    informations 
   TABLE DATA           E   COPY public.informations (id, email, telephone, address) FROM stdin;
    public          postgres    false    216   �?       4          0    16593    pets 
   TABLE DATA           U   COPY public.pets (id, petname, petage, petdescription, petbreed, typeid) FROM stdin;
    public          postgres    false    220   R@       ,          0    16469    roles 
   TABLE DATA           8   COPY public.roles (id, rolename, authority) FROM stdin;
    public          postgres    false    212   �@       1          0    16559    user_informations 
   TABLE DATA           F   COPY public.user_informations (id, userid, informationid) FROM stdin;
    public          postgres    false    217   �@       6          0    16634 	   user_pets 
   TABLE DATA           6   COPY public.user_pets (id, userid, petid) FROM stdin;
    public          postgres    false    222   /A       .          0    16480 
   user_roles 
   TABLE DATA           8   COPY public.user_roles (id, userid, roleid) FROM stdin;
    public          postgres    false    214   fA       *          0    16455    users 
   TABLE DATA           L   COPY public.users (id, username, password, firstname, lastname) FROM stdin;
    public          postgres    false    210   �A       ?           0    0    animaltypes_id_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('public.animaltypes_id_seq', 10003, true);
          public          postgres    false    223            @           0    0    informations_id_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.informations_id_seq', 40, true);
          public          postgres    false    215            A           0    0    pets_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.pets_id_seq', 32050, true);
          public          postgres    false    219            B           0    0    roles_id_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('public.roles_id_seq', 4, true);
          public          postgres    false    211            C           0    0    user_informations_id_seq    SEQUENCE SET     I   SELECT pg_catalog.setval('public.user_informations_id_seq', 1026, true);
          public          postgres    false    218            D           0    0    user_pets_id_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public.user_pets_id_seq', 5044, true);
          public          postgres    false    221            E           0    0    user_roles_id_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public.user_roles_id_seq', 131, true);
          public          postgres    false    213            F           0    0    users_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.users_id_seq', 135, true);
          public          postgres    false    209            �           2606    16697    animaltypes animaltypes_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.animaltypes
    ADD CONSTRAINT animaltypes_pkey PRIMARY KEY (id);
 F   ALTER TABLE ONLY public.animaltypes DROP CONSTRAINT animaltypes_pkey;
       public            postgres    false    224            �           2606    16557    informations informations_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.informations
    ADD CONSTRAINT informations_pkey PRIMARY KEY (id);
 H   ALTER TABLE ONLY public.informations DROP CONSTRAINT informations_pkey;
       public            postgres    false    216            �           2606    16597    pets pets_pkey 
   CONSTRAINT     L   ALTER TABLE ONLY public.pets
    ADD CONSTRAINT pets_pkey PRIMARY KEY (id);
 8   ALTER TABLE ONLY public.pets DROP CONSTRAINT pets_pkey;
       public            postgres    false    220            �           2606    16473    roles roles_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.roles
    ADD CONSTRAINT roles_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.roles DROP CONSTRAINT roles_pkey;
       public            postgres    false    212            �           2606    16576 !   users ukr43af9ap4edm43mmtq01oddj6 
   CONSTRAINT     `   ALTER TABLE ONLY public.users
    ADD CONSTRAINT ukr43af9ap4edm43mmtq01oddj6 UNIQUE (username);
 K   ALTER TABLE ONLY public.users DROP CONSTRAINT ukr43af9ap4edm43mmtq01oddj6;
       public            postgres    false    210            �           2606    16563 (   user_informations user_informations_pkey 
   CONSTRAINT     f   ALTER TABLE ONLY public.user_informations
    ADD CONSTRAINT user_informations_pkey PRIMARY KEY (id);
 R   ALTER TABLE ONLY public.user_informations DROP CONSTRAINT user_informations_pkey;
       public            postgres    false    217            �           2606    16638    user_pets user_pets_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.user_pets
    ADD CONSTRAINT user_pets_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.user_pets DROP CONSTRAINT user_pets_pkey;
       public            postgres    false    222            �           2606    16484    user_roles user_roles_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public.user_roles
    ADD CONSTRAINT user_roles_pkey PRIMARY KEY (id);
 D   ALTER TABLE ONLY public.user_roles DROP CONSTRAINT user_roles_pkey;
       public            postgres    false    214            �           2606    16459    users users_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.users DROP CONSTRAINT users_pkey;
       public            postgres    false    210            �           1259    16574    fki_fk_information    INDEX     Y   CREATE INDEX fki_fk_information ON public.user_informations USING btree (informationid);
 &   DROP INDEX public.fki_fk_information;
       public            postgres    false    217            �           1259    16649    fki_fk_pets    INDEX     B   CREATE INDEX fki_fk_pets ON public.user_pets USING btree (petid);
    DROP INDEX public.fki_fk_pets;
       public            postgres    false    222            �           1259    16496    fki_fk_roles    INDEX     E   CREATE INDEX fki_fk_roles ON public.user_roles USING btree (roleid);
     DROP INDEX public.fki_fk_roles;
       public            postgres    false    214            �           1259    16691    fki_fk_types    INDEX     ?   CREATE INDEX fki_fk_types ON public.pets USING btree (typeid);
     DROP INDEX public.fki_fk_types;
       public            postgres    false    220            �           1259    16490    fki_fk_users    INDEX     E   CREATE INDEX fki_fk_users ON public.user_roles USING btree (userid);
     DROP INDEX public.fki_fk_users;
       public            postgres    false    214            �           1259    16665    fki_fk_usersid    INDEX     F   CREATE INDEX fki_fk_usersid ON public.user_pets USING btree (userid);
 "   DROP INDEX public.fki_fk_usersid;
       public            postgres    false    222            �           2606    16569     user_informations fk_information    FK CONSTRAINT     �   ALTER TABLE ONLY public.user_informations
    ADD CONSTRAINT fk_information FOREIGN KEY (informationid) REFERENCES public.informations(id) NOT VALID;
 J   ALTER TABLE ONLY public.user_informations DROP CONSTRAINT fk_information;
       public          postgres    false    217    216    3210            �           2606    16644    user_pets fk_pets    FK CONSTRAINT     w   ALTER TABLE ONLY public.user_pets
    ADD CONSTRAINT fk_pets FOREIGN KEY (petid) REFERENCES public.pets(id) NOT VALID;
 ;   ALTER TABLE ONLY public.user_pets DROP CONSTRAINT fk_pets;
       public          postgres    false    3216    220    222            �           2606    16491    user_roles fk_roles    FK CONSTRAINT     {   ALTER TABLE ONLY public.user_roles
    ADD CONSTRAINT fk_roles FOREIGN KEY (roleid) REFERENCES public.roles(id) NOT VALID;
 =   ALTER TABLE ONLY public.user_roles DROP CONSTRAINT fk_roles;
       public          postgres    false    212    3204    214            �           2606    16698    pets fk_types    FK CONSTRAINT     {   ALTER TABLE ONLY public.pets
    ADD CONSTRAINT fk_types FOREIGN KEY (typeid) REFERENCES public.animaltypes(id) NOT VALID;
 7   ALTER TABLE ONLY public.pets DROP CONSTRAINT fk_types;
       public          postgres    false    3222    224    220            �           2606    16485    user_roles fk_users    FK CONSTRAINT     {   ALTER TABLE ONLY public.user_roles
    ADD CONSTRAINT fk_users FOREIGN KEY (userid) REFERENCES public.users(id) NOT VALID;
 =   ALTER TABLE ONLY public.user_roles DROP CONSTRAINT fk_users;
       public          postgres    false    210    214    3202            �           2606    16564    user_informations fk_users    FK CONSTRAINT     �   ALTER TABLE ONLY public.user_informations
    ADD CONSTRAINT fk_users FOREIGN KEY (userid) REFERENCES public.users(id) NOT VALID;
 D   ALTER TABLE ONLY public.user_informations DROP CONSTRAINT fk_users;
       public          postgres    false    210    217    3202            �           2606    16660    user_pets fk_usersid    FK CONSTRAINT     |   ALTER TABLE ONLY public.user_pets
    ADD CONSTRAINT fk_usersid FOREIGN KEY (userid) REFERENCES public.users(id) NOT VALID;
 >   ALTER TABLE ONLY public.user_pets DROP CONSTRAINT fk_usersid;
       public          postgres    false    3202    222    210            8   ,   x�34000��NM��22�8�o+H�s�9�K������� �?
`      0   V   x�36�LL���sH�M���K���4���\�����%�C�Ȇ�ļ�Ҝ�v� .���"�б�0731B��Љ���� t�_      4   Z   x�3620��H�-��4�<<-����{*�8�3+s�SS2�39���L����O�4��.-.*���(-ή+1����� ��      ,   '   x�3���q�v�\&G_O?N0����� �y	�      1   ,   x�3402�446�46�2402��9�-@l3 ۔�Ā+F��� ��R      6   '   x�3501�446�4620��2501rMA\S�=... j��      .   '   x�34��446�4�24���9����,S +F��� a�)      *   �   x�5�]N�0  ���<�k+���66B&t�qEJ�݊^ȃx1�f��F�8w�Y9�=Ά���7)V���-���9�R���'�в4�rՋ��Sъƀ�WsS˻`s]�e��OF�~�h�O5�4qy��&Z�m=��}������N�����%�?��LU��G;�nb�8��w����E�h���#�Ny"��8j;��T�߁����(|E�A�P     