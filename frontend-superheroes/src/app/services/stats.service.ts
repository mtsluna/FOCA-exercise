import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {SuperHero} from '../models/superHero';
import {Stats} from '../models/stats';

@Injectable({
  providedIn: 'root'
})
export class StatsService {

  readonly URL = 'http://localhost:8080/api/stats';

  constructor(private http: HttpClient) { }

  findAllStats(): Observable<Stats []> {
    return this.http.get<Stats []>(this.URL);
  }

}
