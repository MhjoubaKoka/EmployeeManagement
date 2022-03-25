import { Role } from "./role";

export class User {
    userName!:string;
    firstName!:string;
    lastName!:string;
    password!:string;
   token!:string;
    roles!:Role[];

   }
