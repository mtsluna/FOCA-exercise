import {Powerstats} from './powerStats';
import {Biography} from './biography';
import {Appearance} from './appearance';
import {Work} from './work';
import {Connections} from './connection';
import {Image} from './image';

export interface SuperHero {
  id: number;
  name: string;
  powerstats: Powerstats;
  biography: Biography;
  appearance: Appearance;
  work: Work;
  connections: Connections;
  image: Image;
}

