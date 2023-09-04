CREATE TABLE "match" (
  "match_id" varchar(70),
  "team1_id" varchar(70),
  "team2_id" varchar(70),
  "date" TIMESTAMP WITHOUT TIME ZONE,
  "match_type" varchar(100),
  "venue" varchar(200),
  "umpire1" integer,
  "umpire2" integer
);